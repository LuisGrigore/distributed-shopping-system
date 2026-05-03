package com.distributedshoppingsystem.authservice.services.implementations;

import com.distributedshoppingsystem.authservice.clients.IUserServiceClient;
import com.distributedshoppingsystem.authservice.dtos.*;
import com.distributedshoppingsystem.authservice.exceptions.UserRegistrationException;
import com.distributedshoppingsystem.authservice.models.AuthUser;
import com.distributedshoppingsystem.authservice.repos.IAuthUserRepo;
import com.distributedshoppingsystem.authservice.services.IAuthService;
import com.distributedshoppingsystem.authservice.services.IJwtService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final IAuthUserRepo authUserRepo;
    private final IJwtService jwtService;
    private final IUserServiceClient userServiceClient;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        UserCreatedDto createdUser;
        try {
            createdUser = userServiceClient.createUser(
                    CreateUserDto.builder()
                            .firstName(registerRequest.firstName())
                            .lastName(registerRequest.lastName())
                            .phoneNumber(registerRequest.phoneNumber())
                            .email(registerRequest.email())
                            .build()
            );

        } catch (FeignException.Conflict e) {
            throw new UserRegistrationException("Email already in use");
        } catch (FeignException e) {
            throw new UserRegistrationException("Error communicating with user service");
        }
        AuthUser authUser = AuthUser.builder()
                .userId(createdUser.id())
                .email(createdUser.email())
                .passwordHash(passwordEncoder.encode(registerRequest.password()))
                .active(createdUser.active())
                .createdAt(createdUser.createdAt())
                .updatedAt(createdUser.updatedAt())
                .build();
        authUserRepo.save(authUser);

        return new AuthResponse(jwtService.generateToken(createdUser.id(), createdUser.email()));
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        AuthUser authUser = authUserRepo.findByEmail(loginRequest.email())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(loginRequest.password(), authUser.getPasswordHash())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        return new AuthResponse(jwtService.generateToken(authUser.getUserId(), authUser.getEmail()));
    }
}