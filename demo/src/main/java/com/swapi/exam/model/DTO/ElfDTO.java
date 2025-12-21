package com.swapi.exam.model.DTO;

import com.swapi.exam.util.enums.SkillLevelEnum;

public class ElfDTO {
    private String name;
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
