package com.distributedshoppingsystem.userservice.dtos;

import lombok.Builder;

@Builder
public record UserDetailsDto(String firstName,
                             String lastName,
                             String phoneNumber,
                             String email,
                             boolean active) {
}
