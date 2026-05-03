package com.distributedshoppingsystem.authservice.dtos;

public record RegisterRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String password
) {}