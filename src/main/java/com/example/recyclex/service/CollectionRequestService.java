package com.example.recyclex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.recyclex.entity.CollectionRequest;
import com.example.recyclex.exception.ResourceNotFoundException;
import com.example.recyclex.repository.CollectionRequestRepository;

@Service
public class CollectionRequestService {

    @Autowired
    CollectionRequestRepository repo;

    public CollectionRequest saveCollection(CollectionRequest data) {
        return repo.save(data);
    }

    public List<CollectionRequest> getAllCollections() {
        return repo.findAll();
    }

    public CollectionRequest getCollectionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found"));
    }

    public CollectionRequest updateCollection(Long id, CollectionRequest data) {

        CollectionRequest viewData = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found"));

        viewData.setPickupAddress(data.getPickupAddress());
        viewData.setScheduledDate(data.getScheduledDate());
        viewData.setStatus(data.getStatus());
        viewData.setTotalWeightEstimate(data.getTotalWeightEstimate());
        viewData.setRewardPointsEarned(data.getRewardPointsEarned());

        return repo.save(viewData);
    }

    public CollectionRequest deleteCollection(Long id) {

        CollectionRequest collection = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found"));
        repo.delete(collection);
        return collection;
    }
}