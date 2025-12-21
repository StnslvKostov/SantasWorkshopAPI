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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillLevelEnum getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevelEnum skillLevel) {
        this.skillLevel = skillLevel;
    }

    public List<Long> getAssignedGiftIds() {
        return assignedGiftIds;
    }

    public void setAssignedGiftIds(List<Long> assignedGiftIds) {
        this.assignedGiftIds = assignedGiftIds;
    }
}
