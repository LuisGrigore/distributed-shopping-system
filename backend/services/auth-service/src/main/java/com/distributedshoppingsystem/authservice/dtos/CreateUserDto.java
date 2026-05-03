package com.distributedshoppingsystem.authservice.dtos;

import lombok.Builder;

@Builder
public record CreateUserDto(String firstName,
                            String lastName,
                            String phoneNumber,
                            String email) {}
