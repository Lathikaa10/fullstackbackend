package com.example.recyclex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.recyclex.entity.SystemUser;
import com.example.recyclex.repository.SystemUserRepository;

@Service
public class SystemUserService {

    @Autowired
    private SystemUserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SystemUser saveUser(SystemUser data) {
        if (data.getPassword() != null && !data.getPassword().isEmpty()) {
            data.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        return repo.save(data);
    }

    public List<SystemUser> getAllUsers() {
        return repo.findAll();
    }

    public SystemUser getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public SystemUser updateUser(Long id, SystemUser data) {
        SystemUser existing = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(data.getUsername());
        existing.setEmail(data.getEmail());
        existing.setRole(data.getRole());

        if (data.getPassword() != null && !data.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(data.getPassword()));
        }

        existing.setRewardPoints(data.getRewardPoints());
        existing.setOrganicWaste(data.getOrganicWaste());
        existing.setRecyclableWaste(data.getRecyclableWaste());
        existing.setNonRecyclableWaste(data.getNonRecyclableWaste());
        existing.setHazardousWaste(data.getHazardousWaste());
        existing.setCollectedWasteBalance(data.getCollectedWasteBalance());
        existing.setTotalContributedKg(data.getTotalContributedKg());
        existing.setPendingWasteKg(data.getPendingWasteKg());

        return repo.save(existing);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}