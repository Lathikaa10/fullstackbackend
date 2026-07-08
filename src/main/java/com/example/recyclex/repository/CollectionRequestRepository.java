package com.example.recyclex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recyclex.entity.CollectionRequest;

@Repository

public interface CollectionRequestRepository extends JpaRepository<CollectionRequest, Long> {

}
