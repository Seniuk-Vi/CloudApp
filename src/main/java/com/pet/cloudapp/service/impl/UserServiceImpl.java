package com.pet.cloudapp.service.impl;

import com.pet.cloudapp.DTO.UserDto;
import com.pet.cloudapp.mapper.UserMapper;
import com.pet.cloudapp.repository.UserRepository;
import com.pet.cloudapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepoImpl;

    @Override
    public UserDto getUser(String email) {
        var user = userRepoImpl.findUserByEmail(email);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        var user = userRepoImpl.save(UserMapper.INSTANCE.mapUser(userDto));
        return UserMapper.INSTANCE.mapUserDto(user);
    }
}
