package com.example.recyclex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;

    private Double rewardPoints;
    private Double organicWaste;
    private Double recyclableWaste;
    private Double nonRecyclableWaste;
    private Double hazardousWaste;
    private Double collectedWasteBalance;
    private Double totalContributedKg;
    private Double pendingWasteKg;

    public SystemUser() {
    }

    public SystemUser(Long id, String username, String email, String password, String role,
            Double rewardPoints, Double organicWaste, Double recyclableWaste,
            Double nonRecyclableWaste, Double hazardousWaste,
            Double collectedWasteBalance, Double totalContributedKg,
            Double pendingWasteKg) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rewardPoints = rewardPoints;
        this.organicWaste = organicWaste;
        this.recyclableWaste = recyclableWaste;
        this.nonRecyclableWaste = nonRecyclableWaste;
        this.hazardousWaste = hazardousWaste;
        this.collectedWasteBalance = collectedWasteBalance;
        this.totalContributedKg = totalContributedKg;
        this.pendingWasteKg = pendingWasteKg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Double getOrganicWaste() {
        return organicWaste;
    }

    public void setOrganicWaste(Double organicWaste) {
        this.organicWaste = organicWaste;
    }

    public Double getRecyclableWaste() {
        return recyclableWaste;
    }

    public void setRecyclableWaste(Double recyclableWaste) {
        this.recyclableWaste = recyclableWaste;
    }

    public Double getNonRecyclableWaste() {
        return nonRecyclableWaste;
    }

    public void setNonRecyclableWaste(Double nonRecyclableWaste) {
        this.nonRecyclableWaste = nonRecyclableWaste;
    }

    public Double getHazardousWaste() {
        return hazardousWaste;
    }

    public void setHazardousWaste(Double hazardousWaste) {
        this.hazardousWaste = hazardousWaste;
    }

    public Double getCollectedWasteBalance() {
        return collectedWasteBalance;
    }

    public void setCollectedWasteBalance(Double collectedWasteBalance) {
        this.collectedWasteBalance = collectedWasteBalance;
    }

    public Double getTotalContributedKg() {
        return totalContributedKg;
    }

    public void setTotalContributedKg(Double totalContributedKg) {
        this.totalContributedKg = totalContributedKg;
    }

    public Double getPendingWasteKg() {
        return pendingWasteKg;
    }

    public void setPendingWasteKg(Double pendingWasteKg) {
        this.pendingWasteKg = pendingWasteKg;
    }
}
