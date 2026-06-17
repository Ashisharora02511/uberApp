package com.java.uber.uberApp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.uber.uberApp.dto.SignupDto;
import com.java.uber.uberApp.dto.UserDto;
import com.java.uber.uberApp.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignupDto signupDto) {
        return authService.signup(signupDto);
    }

}