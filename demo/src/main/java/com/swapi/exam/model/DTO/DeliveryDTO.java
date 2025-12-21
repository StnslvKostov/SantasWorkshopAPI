package com.swapi.exam.model.DTO;

import com.swapi.exam.util.enums.DeliveryStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryDTO {
    private String address;
    private String recipientName;
    private List<Long> giftIds;
    private DeliveryStatusEnum deliveryStatus;
    private LocalDateTime estimatedArrival;

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
