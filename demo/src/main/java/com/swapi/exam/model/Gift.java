package com.swapi.exam.model;

import com.swapi.exam.util.enums.CategoryEnum;
import com.swapi.exam.util.enums.GiftStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gift")

public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    private Integer targetAge;
    private boolean isWrapped;
    @Enumerated(EnumType.STRING)
    private GiftStatusEnum giftStatus;
    private LocalDateTime createdAt;

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

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Integer getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(Integer targetAge) {
        this.targetAge = targetAge;
    }

    public boolean isWrapped() {
        return isWrapped;
    }

    public void setWrapped(boolean wrapped) {
        isWrapped = wrapped;
    }

    public GiftStatusEnum getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(GiftStatusEnum giftStatus) {
        this.giftStatus = giftStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
