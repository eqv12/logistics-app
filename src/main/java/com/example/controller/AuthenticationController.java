package com.example.controller;

import com.example.model.AuthToken;
import com.example.model.LoginRequest;
import com.example.model.RegisterRequest;
import com.example.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")  // Base path for authentication-related endpoints
public class AuthenticationController implements AuthenticationApi{

    @Autowired
    private AuthenticationService authService;

    // Login endpoint (POST request)
    @PostMapping("/login")
    public ResponseEntity<AuthToken> loginUser(@RequestBody LoginRequest loginRequest) {
        AuthToken token = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(token);
    }

    // Register endpoint (POST request)
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.status(201).build();
    }

    // Logout endpoint (No-op for stateless JWT)
    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser() {
        return ResponseEntity.noContent().build();
    }
}
