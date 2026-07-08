package com.example.recyclex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recyclex.entity.ProcessingBatch;

@Repository
public interface ProcessingBatchRepository extends JpaRepository<ProcessingBatch, Long> {

}
