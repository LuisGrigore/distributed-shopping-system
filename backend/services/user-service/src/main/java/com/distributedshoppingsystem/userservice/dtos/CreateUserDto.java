package com.distributedshoppingsystem.userservice.dtos;

import lombok.Builder;

@Builder
public record CreateUserDto(String firstName,
                            String lastName,
                            String phoneNumber,
                            String email) {}
