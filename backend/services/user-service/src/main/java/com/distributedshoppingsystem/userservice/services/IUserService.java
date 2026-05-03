package com.distributedshoppingsystem.userservice.services;


import com.distributedshoppingsystem.userservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.userservice.dtos.UserCreatedDto;
import com.distributedshoppingsystem.userservice.dtos.UserDetailsDto;

import java.util.UUID;

public interface IUserService {
    UserCreatedDto createUser(CreateUserDto createUserDto);
    UserDetailsDto getUserDetails(UUID userId);
}
