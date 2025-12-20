package com.swapi.exam.service;

import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Gift;
import com.swapi.exam.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftService {
    @Autowired
    private GiftRepository giftRepository;

    public Gift create(GiftDTO dto){
        Gift gift = new Gift();
        gift.setCreatedAt(dto.getCreatedAt());
        gift.setGiftStatus(dto.getGiftStatus());
        gift.setCategory(dto.getCategory());
        gift.setName(dto.getName());
        gift.setWrapped(dto.isWrapped());

        return giftRepository.save(gift);
    }
}
