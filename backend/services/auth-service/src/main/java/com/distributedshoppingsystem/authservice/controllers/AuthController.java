package com.distributedshoppingsystem.authservice.controllers;

import com.distributedshoppingsystem.authservice.dtos.AuthResponse;
import com.distributedshoppingsystem.authservice.dtos.LoginRequest;
import com.distributedshoppingsystem.authservice.dtos.RegisterRequest;
import com.distributedshoppingsystem.authservice.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}