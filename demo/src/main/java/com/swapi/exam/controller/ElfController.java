package com.swapi.exam.controller;

import com.swapi.exam.model.DTO.ElfDTO;
import com.swapi.exam.model.Elf;
import com.swapi.exam.service.ElfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elves")
public class ElfController {

    @Autowired
    ElfService elfService;
    @PostMapping
    public ResponseEntity<Elf> create(@RequestBody ElfDTO elfDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(elfService.create(elfDTO));
    }

}
