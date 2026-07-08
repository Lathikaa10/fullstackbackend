package com.example.recyclex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.recyclex.entity.RecyclingFacility;
import com.example.recyclex.exception.ResourceNotFoundException;
import com.example.recyclex.repository.RecyclingFacilityRepository;

@Service
public class RecyclingFacilityService {

    @Autowired
    RecyclingFacilityRepository repo;

    public RecyclingFacility saveFacility(RecyclingFacility data) {
        return repo.save(data);
    }

    public List<RecyclingFacility> getAllFacilities() {
        return repo.findAll();
    }

    public RecyclingFacility getFacilityById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
    }

    public RecyclingFacility updateFacility(Long id, RecyclingFacility data) {

        RecyclingFacility viewData = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));

        viewData.setName(data.getName());
        viewData.setLocation(data.getLocation());
        viewData.setMaxCapacityKg(data.getMaxCapacityKg());
        viewData.setCurrentOccupancyKg(data.getCurrentOccupancyKg());

        return repo.save(viewData);
    }

    public RecyclingFacility deleteFacility(Long id) {

        RecyclingFacility facility = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));

        repo.delete(facility);
        return facility;
    }
}