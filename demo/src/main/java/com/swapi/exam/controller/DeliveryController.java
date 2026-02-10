package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.DeliveryDTO;
import com.swapi.exam.model.Delivery;
import com.swapi.exam.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/deliveries")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Delivery> create(@Valid @RequestBody DeliveryDTO deliveryDTO) throws ClassNotFoundException {
            return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.create(deliveryDTO));
    }
    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.getAllDeliveries());
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity updateDeliveryStatus(@PathVariable long id, @Valid @RequestBody DeliveryDTO deliveryDTO){
            deliveryService.updateDeliveryStatus(id, deliveryDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}
