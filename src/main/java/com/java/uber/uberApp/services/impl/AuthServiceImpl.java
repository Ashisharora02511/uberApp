package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.SignupDto;
import com.java.uber.uberApp.dto.UserDto;
import com.java.uber.uberApp.services.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public void login(String email, String password) {

    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(String userId) {
        return null;
    }
}
