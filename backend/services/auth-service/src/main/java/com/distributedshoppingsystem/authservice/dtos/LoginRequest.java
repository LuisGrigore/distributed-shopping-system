package com.distributedshoppingsystem.authservice.dtos;

public record LoginRequest(
        String email,
        String password
) {}