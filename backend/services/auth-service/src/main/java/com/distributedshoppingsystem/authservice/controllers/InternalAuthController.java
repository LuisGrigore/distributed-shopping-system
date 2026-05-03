package com.distributedshoppingsystem.authservice.controllers;

import com.distributedshoppingsystem.authservice.dtos.ValidationResponse;
import com.distributedshoppingsystem.authservice.services.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/internal/auth")
@RequiredArgsConstructor
public class InternalAuthController {

    private final IJwtService jwtService;

    @GetMapping("/validate")
    public ResponseEntity<ValidationResponse> validateToken(
            @RequestHeader("Authorization") String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }

        String token = authHeader.substring(7);

        try {
            ValidationResponse response = jwtService.validateAndExtract(token);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build();
        }
    }
}

