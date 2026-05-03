package com.distributedshoppingsystem.authservice.services;

import com.distributedshoppingsystem.authservice.dtos.AuthResponse;
import com.distributedshoppingsystem.authservice.dtos.LoginRequest;
import com.distributedshoppingsystem.authservice.dtos.RegisterRequest;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}