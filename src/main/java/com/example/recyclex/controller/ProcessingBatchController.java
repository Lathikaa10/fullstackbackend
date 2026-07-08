package com.example.recyclex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.recyclex.entity.ProcessingBatch;
import com.example.recyclex.service.ProcessingBatchService;

@RestController
@RequestMapping("/batches")
public class ProcessingBatchController {

    @Autowired
    private ProcessingBatchService service;

    @PostMapping
    public ProcessingBatch saveBatch(@RequestBody ProcessingBatch batch) {
        return service.saveBatch(batch);
    }

    @GetMapping
    public List<ProcessingBatch> getAllBatches() {
        return service.getAllBatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBatch(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getBatchById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Batch not found");
        }
    }

    @PutMapping("/{id}")
    public ProcessingBatch updateBatch(@PathVariable Long id,
            @RequestBody ProcessingBatch batch) {
        return service.updateBatch(id, batch);
    }

    @PatchMapping("/{id}")
    public ProcessingBatch patchBatch(@PathVariable Long id,
            @RequestBody ProcessingBatch batch) {
        return service.updateBatch(id, batch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBatch(@PathVariable Long id) {
        try {
            service.deleteBatch(id);
            return ResponseEntity.ok("Batch deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Batch not found");
        }
    }
}
