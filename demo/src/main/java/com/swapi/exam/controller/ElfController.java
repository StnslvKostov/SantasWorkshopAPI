package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.ElfDTO;
import com.swapi.exam.model.Elf;
import com.swapi.exam.service.ElfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elves")
public class ElfController {

    @Autowired
    ElfService elfService;

    @PostMapping
    public ResponseEntity<Elf> create(@Valid @RequestBody ElfDTO elfDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(elfService.create(elfDTO));
    }

    @GetMapping
    public ResponseEntity<List<Elf>> getAllElves() {
        return ResponseEntity.status(HttpStatus.OK).body(elfService.getAllElves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Elf> getById(@PathVariable long id) throws ClassNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(elfService.getElfById(id));

    }

    @DeleteMapping("/{id}")

    public ResponseEntity deleteElf(@PathVariable long id) {
        elfService.deleteElf(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{elfId}/assign/{giftId}")
    public ResponseEntity AssignGiftElf(@PathVariable long elfId, @PathVariable long giftId) throws ClassNotFoundException {
            return ResponseEntity.status(HttpStatus.OK).body(elfService.assignedGiftToElf(elfId, giftId));
    }
}
