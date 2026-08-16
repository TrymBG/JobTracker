package com.jobtracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jobtracker.dto.RegisterRequest;


@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/auth/register")
    public void registerUser(@RequestBody RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        String password = registerRequest.getPassword();

        userService.registerUser(username, password);
    }

}