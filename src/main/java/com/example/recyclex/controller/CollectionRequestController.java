package com.example.recyclex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recyclex.entity.CollectionRequest;
import com.example.recyclex.service.CollectionRequestService;

@RestController
@RequestMapping("/collections")
public class CollectionRequestController {

    @Autowired
    private CollectionRequestService service;

    @PostMapping
    public CollectionRequest saveCollection(@RequestBody CollectionRequest collection) {
        return service.saveCollection(collection);
    }

    @GetMapping
    public List<CollectionRequest> getAllCollections() {
        return service.getAllCollections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCollection(@PathVariable Long id) {
        try {
            CollectionRequest collection = service.getCollectionById(id);
            return ResponseEntity.ok(collection);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Collection not found");
        }
    }

    @PutMapping("/{id}")
    public CollectionRequest updateCollection(
            @PathVariable Long id,
            @RequestBody CollectionRequest collection) {

        return service.updateCollection(id, collection);
    }

    
    @PatchMapping("/{id}")
    public CollectionRequest patchCollection(
            @PathVariable Long id,
            @RequestBody CollectionRequest collection) {

        return service.updateCollection(id, collection);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollection(@PathVariable Long id) {
        try {
            service.deleteCollection(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Collection deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Collection not found");
        }
    }
}
