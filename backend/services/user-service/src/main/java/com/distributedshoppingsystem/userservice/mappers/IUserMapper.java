package com.distributedshoppingsystem.userservice.mappers;

import com.distributedshoppingsystem.userservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.userservice.dtos.UserCreatedDto;
import com.distributedshoppingsystem.userservice.dtos.UserDetailsDto;
import com.distributedshoppingsystem.userservice.models.User;

public interface IUserMapper {
    User fromCreateUserDto(CreateUserDto createUserDto);
    UserCreatedDto toUserCreatedDto(User user);
    UserDetailsDto toUserDetailsDto(User user);
}
