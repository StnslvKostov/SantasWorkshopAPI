package com.swapi.exam.model;

import com.swapi.exam.util.enums.CategoryEnum;
import com.swapi.exam.util.enums.GiftStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
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

}
