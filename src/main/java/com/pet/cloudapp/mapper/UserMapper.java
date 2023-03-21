package com.pet.cloudapp.mapper;

import com.pet.cloudapp.DTO.UserDto;
import com.pet.cloudapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto mapUserDto(User user);
    User mapUser(UserDto user);
}
