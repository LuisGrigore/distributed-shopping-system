package com.distributedshoppingsystem.userservice.repos;

import com.distributedshoppingsystem.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepo  extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
}
