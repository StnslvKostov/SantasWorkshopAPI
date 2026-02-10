package com.swapi.exam.model.DTO;

import com.swapi.exam.util.enums.CategoryEnum;
import com.swapi.exam.util.enums.GiftStatusEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO {

    private Long id;

    @NotBlank(message = "Gift name is required")
    @Size(min = 2, max = 20, message = "Gift name must be between 2 and 20 characters")
    private String name;

    @NotNull(message = "Category is required")
    private CategoryEnum category;

    @NotNull(message = "Target age is required")
    @Min(value = 0, message = "Target age cannot be negative")
    @Max(value = 18, message = "Target age cannot be greater than 18")
    private Integer targetAge;

    @NotNull(message = "Wrapped flag is required")
    private boolean isWrapped;

    @NotNull(message = "Gift status is required")
    private GiftStatusEnum giftStatus;

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
}