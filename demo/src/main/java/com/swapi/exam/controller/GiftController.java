package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {
    @Autowired
    private GiftService giftService;

    @PostMapping
    public void create(@RequestBody GiftDTO giftDTO) {
        giftService.create(giftDTO);
    }
}
