package com.example.recyclex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.recyclex.entity.RecyclableItem;
import com.example.recyclex.exception.ResourceNotFoundException;
import com.example.recyclex.repository.RecyclableItemRepository;

@Service
public class RecyclableItemService {

    @Autowired
    RecyclableItemRepository repo;

    public RecyclableItem saveItem(RecyclableItem data) {
        return repo.save(data);
    }

    public List<RecyclableItem> getAllItems() {
        return repo.findAll();
    }

    public RecyclableItem getItemById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }

    public RecyclableItem updateItem(Long id, RecyclableItem data) {
        RecyclableItem viewData = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

        viewData.setMaterialType(data.getMaterialType());
        viewData.setActualWeight(data.getActualWeight());
        viewData.setQualityGrade(data.getQualityGrade());

        return repo.save(viewData);
    }

    public RecyclableItem deleteItem(Long id) {
        RecyclableItem item = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        repo.delete(item);
        return item;
    }

}