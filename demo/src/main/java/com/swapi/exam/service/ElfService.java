package com.swapi.exam.service;

import com.swapi.exam.model.DTO.ElfDTO;
import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Elf;
import com.swapi.exam.model.Gift;
import com.swapi.exam.repository.ElfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ElfService {

    @Autowired
    ElfRepository elfRepository;

    public Elf create(ElfDTO elfDTO){
        Elf elf = new Elf();
        elf.setName(elfDTO.getName());
        elf.setSkillLevel(elfDTO.getSkillLevel());

        return elfRepository.save(elf);
    }

    public List<Elf> getAllElves(){
        return elfRepository.findAll();
    }
    public Elf getElfById(long id) throws ClassNotFoundException{
        return elfRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }
    public void deleteElf(long id){
        elfRepository.deleteById(id);
    }
}
