package com.swapi.exam.service;

import com.swapi.exam.model.DTO.ElfDTO;
import com.swapi.exam.model.DTO.GiftDTO;
import com.swapi.exam.model.Elf;
import com.swapi.exam.model.Gift;
import com.swapi.exam.repository.ElfRepository;
import com.swapi.exam.repository.GiftRepository;
import com.swapi.exam.util.enums.GiftStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ElfService {

    @Autowired
    ElfRepository elfRepository;
    @Autowired
    GiftService giftService;

    public Elf create(ElfDTO elfDTO){
        Elf elf = new Elf();
        elf.setName(elfDTO.getName());
        elf.setSkillLevel(elfDTO.getSkillLevel());
        elf.setAssignedGiftIds(new ArrayList<>());

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
    public Elf assignedGiftToElf (long elfId, long giftId) throws ClassNotFoundException {
        Elf elf = getElfById(elfId);
        Gift gift = giftService.getGiftById(giftId);
        if(gift.getGiftStatus()== GiftStatusEnum.DELIVERED){
            throw new IllegalArgumentException();
        }
        elf.getAssignedGiftIds().add(giftId);
        return elfRepository.save(elf);
    }
}
