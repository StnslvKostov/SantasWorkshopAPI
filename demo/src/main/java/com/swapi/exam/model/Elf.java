package com.swapi.exam.model;


import com.swapi.exam.util.enums.SkillLevelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "elf")
public class Elf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private SkillLevelEnum skillLevel;
    private List<Long> assignedGiftId;
}
