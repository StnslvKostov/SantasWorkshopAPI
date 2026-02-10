package com.swapi.exam.model.DTO;

import com.swapi.exam.util.enums.SkillLevelEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ElfDTO {
    @NotBlank(message = "Elf name is required")
    @Size(min = 2, max = 12, message = "Elf name must be between 2 and 12 characters")
    private String name;
    @NotNull(message = "Skill level is required")
    private SkillLevelEnum skillLevel;

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
}
