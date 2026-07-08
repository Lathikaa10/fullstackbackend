package com.example.recyclex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProcessingBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Double totalBatchWeight;

    public ProcessingBatch(Long id, String status, Double totalBatchWeight) {
        this.id = id;
        this.status = status;
        this.totalBatchWeight = totalBatchWeight;
    }

    public ProcessingBatch() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalBatchWeight() {
        return totalBatchWeight;
    }

    public void setTotalBatchWeight(Double totalBatchWeight) {
        this.totalBatchWeight = totalBatchWeight;
    }

}
