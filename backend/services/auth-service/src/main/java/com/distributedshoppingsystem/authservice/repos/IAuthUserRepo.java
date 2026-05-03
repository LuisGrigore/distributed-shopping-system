package com.distributedshoppingsystem.authservice.repos;

import com.distributedshoppingsystem.authservice.models.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IAuthUserRepo extends JpaRepository<AuthUser, UUID> {
    Optional<AuthUser> findByEmail(String email);
}