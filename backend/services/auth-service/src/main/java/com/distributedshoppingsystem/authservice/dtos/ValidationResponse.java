package com.distributedshoppingsystem.authservice.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ValidationResponse(UUID userId, String email, boolean isActive) {
}
