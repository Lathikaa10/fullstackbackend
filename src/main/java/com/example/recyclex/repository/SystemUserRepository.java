package com.example.recyclex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recyclex.entity.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    List<SystemUser> findByEmail(String email);

}