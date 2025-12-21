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
@Table(name = "elf")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String recipientName;
    @ElementCollection
    @CollectionTable(
            name = "delivery_gifts",
            joinColumns = @JoinColumn(name = "delivery_id")
    )
    @Column(name = "gift_id", nullable = false)
    private List<Long> giftIds;
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum deliveryStatus;
    private LocalDateTime estimatedArrival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public List<Long> getGiftIds() {
        return giftIds;
    }

    public void setGiftIds(List<Long> giftIds) {
        this.giftIds = giftIds;
    }

    public DeliveryStatusEnum getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusEnum deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(LocalDateTime estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
}
