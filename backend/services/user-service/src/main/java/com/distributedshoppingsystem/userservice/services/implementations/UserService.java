package com.distributedshoppingsystem.userservice.services.implementations;
import com.distributedshoppingsystem.userservice.dtos.CreateUserDto;
import com.distributedshoppingsystem.userservice.dtos.UserCreatedDto;
import com.distributedshoppingsystem.userservice.dtos.UserDetailsDto;
import com.distributedshoppingsystem.userservice.exceptions.EmailAlreadyExistsException;
import com.distributedshoppingsystem.userservice.exceptions.UserCreationException;
import com.distributedshoppingsystem.userservice.exceptions.UserNotFoundException;
import com.distributedshoppingsystem.userservice.mappers.IUserMapper;
import com.distributedshoppingsystem.userservice.models.User;
import com.distributedshoppingsystem.userservice.repos.IUserRepo;
import com.distributedshoppingsystem.userservice.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepo userRepo;
    private final IUserMapper userMapper;

    @Override
    public UserCreatedDto createUser(CreateUserDto createUserDto) {
        if (userRepo.existsByEmail(createUserDto.email())) {
            throw new EmailAlreadyExistsException("Email already in use");
        }
        try {
            return userMapper.toUserCreatedDto(
                    userRepo.save(userMapper.fromCreateUserDto(createUserDto))
            );
        } catch (Exception e) {
            throw new UserCreationException("Error creating user", e);
        }
    }

    @Override
    public UserDetailsDto getUserDetails(UUID userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toUserDetailsDto(user);
    }
}