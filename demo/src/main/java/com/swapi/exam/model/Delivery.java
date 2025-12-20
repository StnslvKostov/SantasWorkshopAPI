package com.swapi.exam.model;

import com.swapi.exam.util.enums.DeliveryStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "elf")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String recipientName;
    private List<Long> giftIds;
    private DeliveryStatusEnum deliveryStatus;
    private LocalDateTime estimatedArrival;
}
