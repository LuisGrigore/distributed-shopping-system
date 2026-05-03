package com.distributedshoppingsystem.gateway.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ValidationResponse(UUID userId, String email, boolean isActive) {
}
