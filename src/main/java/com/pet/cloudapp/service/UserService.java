package com.pet.cloudapp.service;

import com.pet.cloudapp.DTO.UserDto;

public interface UserService {

    UserDto getUser(String email);
    UserDto createUser(UserDto userDto);
}
