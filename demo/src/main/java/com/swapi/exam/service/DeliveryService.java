package com.swapi.exam.service;

import com.swapi.exam.model.DTO.DeliveryDTO;
import com.swapi.exam.model.Delivery;
import com.swapi.exam.model.Gift;
import com.swapi.exam.repository.DeliveryRepository;
import com.swapi.exam.repository.GiftRepository;
import com.swapi.exam.util.enums.DeliveryStatusEnum;
import com.swapi.exam.util.enums.GiftStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    GiftService giftService;


    @Transactional
    public Delivery create(DeliveryDTO deliveryDTO) throws ClassNotFoundException {
        Delivery delivery = new Delivery();
        delivery.setDeliveryStatus(DeliveryStatusEnum.PLANNED);
        delivery.setAddress(deliveryDTO.getAddress());
        delivery.setEstimatedArrival(LocalDateTime.now().plusDays(3));
        delivery.setRecipientName(deliveryDTO.getRecipientName());
        for (long giftId : deliveryDTO.getGiftIds()) {
            Gift gift = giftService.getGiftById(giftId);
            if (gift.getGiftStatus() != GiftStatusEnum.LOADED && gift.getGiftStatus() != GiftStatusEnum.READY) {
                throw new ClassNotFoundException();
            }
            giftService.updateGiftStatus(giftId, GiftStatusEnum.LOADED);

        }
        delivery.setGiftIds(deliveryDTO.getGiftIds());
        return deliveryRepository.save(delivery);
    }
    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }
    public void updateDeliveryStatus(long id, DeliveryDTO deliveryDTO) throws IllegalArgumentException{
        Delivery delivery = deliveryRepository.findById(id).get();
        if(delivery.getDeliveryStatus() == DeliveryStatusEnum.DELIVERED && deliveryDTO.getDeliveryStatus() == DeliveryStatusEnum.PLANNED){
            throw new IllegalArgumentException();
        }
        delivery.setDeliveryStatus(deliveryDTO.getDeliveryStatus());
        if(delivery.getDeliveryStatus() == DeliveryStatusEnum.DELIVERED){
            for (long giftId: delivery.getGiftIds()) {
                giftService.updateGiftStatus(giftId, GiftStatusEnum.DELIVERED);
            }
        }
        deliveryRepository.save(delivery);
    }
}
