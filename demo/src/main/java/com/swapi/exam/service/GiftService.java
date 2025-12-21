package com.swapi.exam.service;

import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Gift;
import com.swapi.exam.repository.GiftRepository;
import com.swapi.exam.util.enums.CategoryEnum;
import com.swapi.exam.util.enums.GiftStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class GiftService {
    @Autowired
    private GiftRepository giftRepository;

    public Gift create(GiftDTO dto){
        Gift gift = new Gift();
        gift.setCreatedAt(LocalDateTime.now());
        gift.setGiftStatus(dto.getGiftStatus());
        gift.setCategory(dto.getCategory());
        gift.setName(dto.getName());
        gift.setWrapped(dto.isWrapped());
        gift.setTargetAge(dto.getTargetAge());

        return giftRepository.save(gift);
    }
    public List<Gift> getAll(String status, String category, String wrapped, String size, String page, String sort) {
        List<Gift> listGifts = giftRepository.findAll();

        Stream<Gift> stream = listGifts.stream();

        if (status != null && !status.isBlank()) {
            GiftStatusEnum statusEnum = GiftStatusEnum.valueOf(status.toUpperCase());
            stream = stream.filter(g -> g.getGiftStatus() == statusEnum);
        }

        if (category != null && !category.isBlank()) {
            CategoryEnum categoryEnum = CategoryEnum.valueOf(category.toUpperCase());
            stream = stream.filter(g -> g.getCategory() == categoryEnum);
        }

        if (wrapped != null && !wrapped.isBlank()) {
            boolean wrappedBool = Boolean.parseBoolean(wrapped);
            stream = stream.filter(g -> g.isWrapped() == wrappedBool);
        }

        if (sort != null && !sort.isBlank()) {
            switch (sort) {
                case "createdAt" ->
                        stream = stream.sorted(Comparator.comparing(Gift::getCreatedAt));

                case "name" ->
                        stream = stream.sorted(Comparator.comparing(Gift::getName));
            }
        }

        if (page != null && size != null) {
            return stream
                    .skip((long) Integer.parseInt(page) * Integer.parseInt(size))
                    .limit(Integer.parseInt(size))
                    .toList();
        } else {
            return listGifts;
        }
    }
    }

