package com.distributedshoppingsystem.authservice.services;

import com.distributedshoppingsystem.authservice.dtos.ValidationResponse;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId, String email);
    ValidationResponse validateAndExtract(String token);
}
