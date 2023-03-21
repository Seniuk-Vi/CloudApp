package com.pet.cloudapp.api;

import com.pet.cloudapp.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface LoginApi {


    @PostMapping("/login")
    ResponseEntity<User> login(@RequestBody String email, @RequestBody String password);
    @PostMapping("/register")
    ResponseEntity<User> register(@RequestBody User user);
}
