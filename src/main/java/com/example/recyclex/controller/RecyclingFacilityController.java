package com.example.recyclex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.recyclex.entity.RecyclingFacility;
import com.example.recyclex.service.RecyclingFacilityService;

@RestController
@RequestMapping("/facilities")
public class RecyclingFacilityController {

    @Autowired
    private RecyclingFacilityService service;

    @PostMapping
    public RecyclingFacility saveFacility(@RequestBody RecyclingFacility facility) {
        return service.saveFacility(facility);
    }

    @GetMapping
    public List<RecyclingFacility> getAllFacilities() {
        return service.getAllFacilities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacility(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getFacilityById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility not found");
        }
    }

    @PutMapping("/{id}")
    public RecyclingFacility updateFacility(@PathVariable Long id,
            @RequestBody RecyclingFacility facility) {

        return service.updateFacility(id, facility);
    }

    @PatchMapping("/{id}")
    public RecyclingFacility patchFacility(@PathVariable Long id,
            @RequestBody RecyclingFacility facility) {
        return service.updateFacility(id, facility);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFacility(@PathVariable Long id) {
        try {
            service.deleteFacility(id);
            return ResponseEntity.ok("Facility deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility not found");
        }
    }
}