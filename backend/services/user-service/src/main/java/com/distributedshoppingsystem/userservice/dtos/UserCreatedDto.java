package com.distributedshoppingsystem.userservice.dtos;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record UserCreatedDto(UUID id,
                             String email,
                             boolean active,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {}
