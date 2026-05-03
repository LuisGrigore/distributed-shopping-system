package com.distributedshoppingsystem.userservice.config;


import com.distributedshoppingsystem.userservice.mappers.IUserMapper;
import com.distributedshoppingsystem.userservice.mappers.implementations.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public IUserMapper userMapper() {
        return new UserMapper();
    }
}
