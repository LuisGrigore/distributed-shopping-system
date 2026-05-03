package com.distributedshoppingsystem.userservice.mappers.implementations;

import com.distributedshoppingsystem.userservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.userservice.dtos.UserCreatedDto;
import com.distributedshoppingsystem.userservice.mappers.IUserMapper;
import com.distributedshoppingsystem.userservice.models.User;

/*    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private String email;*/

/*UUID id,
 String email,
 boolean active,
 LocalDateTime createdAt,
 LocalDateTime updatedAt*/

public class UserMapper implements IUserMapper {

    @Override
    public User fromCreateUserDto(CreateUserDto createUserDto) {
        return User.builder()
                .firstName(createUserDto.firstName())
                .lastName(createUserDto.lastName())
                .phoneNumber(createUserDto.phoneNumber())
                .email(createUserDto.email())
                .build();
    }

    @Override
    public UserCreatedDto toUserCreatedDto(User user) {
        return UserCreatedDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .active(user.isActive())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
