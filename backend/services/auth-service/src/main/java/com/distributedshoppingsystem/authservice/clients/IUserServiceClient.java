package com.distributedshoppingsystem.authservice.clients;

import com.distributedshoppingsystem.authservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.authservice.dtos.UserCreatedDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface IUserServiceClient {

    @PostMapping("/internal/users")
    UserCreatedDto createUser(@RequestBody CreateUserDto createUserDto);
}