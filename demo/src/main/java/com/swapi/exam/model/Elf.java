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
    @Enumerated(EnumType.STRING)
    private SkillLevelEnum skillLevel;
    @ElementCollection
    @CollectionTable(
            name = "elf_assigned_gifts",
            joinColumns = @JoinColumn(name = "elf_id")
    )
    @Column(name = "gift_id", nullable = false)
    private List<Long> assignedGiftIds;
}
