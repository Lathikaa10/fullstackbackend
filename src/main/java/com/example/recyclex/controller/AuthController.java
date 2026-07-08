package com.example.recyclex.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.recyclex.entity.SystemUser;
import com.example.recyclex.repository.SystemUserRepository;
import com.example.recyclex.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // CORS issue varaama irukka
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SystemUserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder; // SecurityConfig-la irukkura Bean

    // LOGIN METHOD
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SystemUser user) {
        try {
            // AuthService vazhiya token generate panrom
            String token = authService.authenticateAndGetToken(user.getEmail(), user.getPassword());

            // DB-la irunthu user details edukrom (role-kaga)
            SystemUser dbUser = userRepository.findByEmail(user.getEmail()).get(0);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("role", dbUser.getRole());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // BadCredentialsException vandha 401 Unauthorized
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }

    // REGISTER METHOD
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SystemUser user) {
        // Email already irukka nu check panrom
        if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
            return ResponseEntity.status(400).body("Email already exists!");
        }

        // PASSWORD HASHING (MUKKIYAM!)
        // Plain text-a DB-la save panna koodathu
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
        return ResponseEntity.ok("Registered Successfully");
    }
}