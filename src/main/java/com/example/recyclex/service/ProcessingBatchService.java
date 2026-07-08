package com.example.recyclex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.recyclex.entity.ProcessingBatch;
import com.example.recyclex.exception.ResourceNotFoundException;
import com.example.recyclex.repository.ProcessingBatchRepository;

@Service
public class ProcessingBatchService {

    @Autowired
    ProcessingBatchRepository repo;

    public ProcessingBatch saveBatch(ProcessingBatch data) {
        return repo.save(data);
    }

    public List<ProcessingBatch> getAllBatches() {
        return repo.findAll();
    }

    public ProcessingBatch getBatchById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found"));
    }

    public ProcessingBatch updateBatch(Long id, ProcessingBatch data) {

        ProcessingBatch viewData = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Batch not found"));

        viewData.setStatus(data.getStatus());
        viewData.setTotalBatchWeight(data.getTotalBatchWeight());

        return repo.save(viewData);
    }

    public ProcessingBatch deleteBatch(Long id) {

        ProcessingBatch batch = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found"));

        repo.delete(batch);
        return batch;
    }
}
