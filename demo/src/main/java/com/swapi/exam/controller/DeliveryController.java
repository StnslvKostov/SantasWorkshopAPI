package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.DeliveryDTO;
import com.swapi.exam.model.Delivery;
import com.swapi.exam.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/deliveries")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @PostMapping
    public ResponseEntity<Delivery> create(@RequestBody DeliveryDTO deliveryDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.create(deliveryDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
