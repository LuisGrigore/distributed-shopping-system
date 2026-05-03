package com.distributedshoppingsystem.userservice.services;


import com.distributedshoppingsystem.userservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.userservice.dtos.UserCreatedDto;

public interface IUserService {
    UserCreatedDto createUser(CreateUserDto createUserDto);
}
