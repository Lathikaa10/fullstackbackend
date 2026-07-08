package com.example.recyclex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recyclex.entity.RecyclableItem;

@Repository
public interface RecyclableItemRepository extends JpaRepository<RecyclableItem, Long> {

}
