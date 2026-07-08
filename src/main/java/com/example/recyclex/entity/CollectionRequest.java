package com.example.recyclex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CollectionRequest {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupAddress;
    private String scheduledDate;
    private String status;
    private Double totalWeightEstimate;
    private Double rewardPointsEarned;

    public CollectionRequest(Long id, String pickupAddress, String scheduledDate, String status,
            Double totalWeightEstimate,
            Double rewardPointsEarned) {
        this.id = id;
        this.pickupAddress = pickupAddress;
        this.scheduledDate = scheduledDate;
        this.status = status;
        this.totalWeightEstimate = totalWeightEstimate;
        this.rewardPointsEarned = rewardPointsEarned;
    }

    public CollectionRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalWeightEstimate() {
        return totalWeightEstimate;
    }

    public void setTotalWeightEstimate(Double totalWeightEstimate) {
        this.totalWeightEstimate = totalWeightEstimate;
    }

    public Double getRewardPointsEarned() {
        return rewardPointsEarned;
    }

    public void setRewardPointsEarned(Double rewardPointsEarned) {
        this.rewardPointsEarned = rewardPointsEarned;
    }

}
