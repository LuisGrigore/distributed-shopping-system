package com.distributedshoppingsystem.authservice.services;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId, String email);
    boolean validateToken(String token);
}
