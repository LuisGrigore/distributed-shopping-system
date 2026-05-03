package com.distributedshoppingsystem.userservice.controllers;

import com.distributedshoppingsystem.userservice.dtos.UserDetailsDto;
import com.distributedshoppingsystem.userservice.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/details")
    public ResponseEntity<UserDetailsDto> getUserDetails(@RequestHeader("X-User-Id") UUID userId) {
        return ResponseEntity.ok(userService.getUserDetails(userId));
    }
}
