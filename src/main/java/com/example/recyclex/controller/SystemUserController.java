package com.example.recyclex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.recyclex.entity.SystemUser;
import com.example.recyclex.service.SystemUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class SystemUserController {

    @Autowired
    private SystemUserService service;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody SystemUser user) {
        try {
            return ResponseEntity.ok(service.saveUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<SystemUser>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody SystemUser user) {
        try {
            return ResponseEntity.ok(service.updateUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}