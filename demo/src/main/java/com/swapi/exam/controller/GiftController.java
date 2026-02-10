package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Gift;
import com.swapi.exam.service.GiftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {
    @Autowired
    private GiftService giftService;

    @PostMapping
    public ResponseEntity<Gift> create(@Valid @RequestBody GiftDTO giftDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(giftService.create(giftDTO));
    }

    @GetMapping
    public ResponseEntity<List<Gift>> getallGifts(@RequestParam(required = false) String status, @RequestParam(required = false) String category, @RequestParam(required = false) String wrapped, @RequestParam(required = false) String size, @RequestParam(required = false) String page, @RequestParam(required = false) String sort) {
        return ResponseEntity.status(HttpStatus.OK).body(giftService.getAll(status, category, wrapped, size, page, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gift> getById(@PathVariable long id) throws ClassNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(giftService.getGiftById(id));
    }

    @PutMapping("/{id}")

    public ResponseEntity<Gift> updateById(@PathVariable long id, @Valid @RequestBody GiftDTO giftDTO) throws ClassNotFoundException {

            return ResponseEntity.status(HttpStatus.OK).body(giftService.updateGiftByID(id, giftDTO));
    }

    @PatchMapping("/{id}/wrap")

    public ResponseEntity<Gift> wrapGift(@PathVariable long id) throws ClassNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(giftService.wrapGift(id));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity deleteGift(@PathVariable long id) {
        giftService.deleteGift(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
