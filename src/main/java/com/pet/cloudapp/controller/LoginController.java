package com.pet.cloudapp.controller;

import com.pet.cloudapp.api.LoginApi;
import com.pet.cloudapp.mapper.UserMapper;
import com.pet.cloudapp.model.User;
import com.pet.cloudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController implements LoginApi {
    public final UserService userService;
    @Override
    public ResponseEntity<User> login(String email, String password) {
        var user = userService.getUser(email);
        if (!user.getPassword().equals(password)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUser(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> register(User user) {
        var userDto = userService.createUser(UserMapper.INSTANCE.mapUserDto(user));
        if(user==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUser(userDto),HttpStatus.ACCEPTED);
    }
}
