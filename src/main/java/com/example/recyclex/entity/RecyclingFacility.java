package com.example.recyclex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecyclingFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Double maxCapacityKg;
    private Double currentOccupancyKg;

    public RecyclingFacility(Long id, String name, String location, Double maxCapacityKg, Double currentOccupancyKg) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.maxCapacityKg = maxCapacityKg;
        this.currentOccupancyKg = currentOccupancyKg;
    }

    public RecyclingFacility() {

    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMaxCapacityKg() {
        return maxCapacityKg;
    }

    public void setMaxCapacityKg(Double maxCapacityKg) {
        this.maxCapacityKg = maxCapacityKg;
    }

    public Double getCurrentOccupancyKg() {
        return currentOccupancyKg;
    }

    public void setCurrentOccupancyKg(Double currentOccupancyKg) {
        this.currentOccupancyKg = currentOccupancyKg;
    }

}
