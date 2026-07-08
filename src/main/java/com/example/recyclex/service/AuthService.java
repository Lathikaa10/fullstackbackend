package com.example.recyclex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.example.recyclex.entity.SystemUser;
import com.example.recyclex.repository.SystemUserRepository;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private SystemUserRepository userRepository;

    // Method to handle authentication and return a JWT token
    public String authenticateAndGetToken(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return jwtService.generateToken(userDetails.getUsername());
    }

    // Method to fetch user details by email to retrieve the role
    public SystemUser getUserByEmail(String email) {
        List<SystemUser> users = userRepository.findByEmail(email);
        return (users != null && !users.isEmpty()) ? users.get(0) : null;
    }
}