package com.example.recyclex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.recyclex.entity.RecyclableItem;
import com.example.recyclex.service.RecyclableItemService;

@RestController
@RequestMapping("/items")
public class RecyclableItemController {

    @Autowired
    private RecyclableItemService service;

    @PostMapping
    public RecyclableItem saveItem(@RequestBody RecyclableItem item) {
        return service.saveItem(item);
    }

    @GetMapping
    public List<RecyclableItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getItemById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }

    @PutMapping("/{id}")
    public RecyclableItem updateItem(@PathVariable Long id, @RequestBody RecyclableItem item) {
        return service.updateItem(id, item);
    }

    @PatchMapping("/{id}")
    public RecyclableItem patchItem(@PathVariable Long id, @RequestBody RecyclableItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            service.deleteItem(id);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }
}