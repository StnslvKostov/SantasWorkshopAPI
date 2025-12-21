package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Gift;
import com.swapi.exam.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {
    @Autowired
    private GiftService giftService;

    @PostMapping
    public ResponseEntity<Gift> create(@RequestBody GiftDTO giftDTO) {
       return ResponseEntity.status(HttpStatus.CREATED).body(giftService.create(giftDTO));
    }

    @GetMapping
    public ResponseEntity<List<Gift>> gifts(@RequestParam(required = false) String status, @RequestParam(required = false) String category, @RequestParam(required = false) String wrapped, @RequestParam(required = false) String size, @RequestParam(required = false) String page, @RequestParam(required = false) String sort){
        return ResponseEntity.status(HttpStatus.OK).body(giftService.getAll(status, category, wrapped, size, page, sort));
    }
}
