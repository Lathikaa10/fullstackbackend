package com.example.recyclex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recyclex.entity.RecyclingFacility;

@Repository
public interface RecyclingFacilityRepository extends JpaRepository<RecyclingFacility, Long> {

}
