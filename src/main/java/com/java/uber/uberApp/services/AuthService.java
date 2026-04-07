package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.SignupDto;
import com.java.uber.uberApp.dto.UserDto;

public interface AuthService {

    void login(String email,String password);

    UserDto signup(SignupDto signupDto);
    DriverDto onboardNewDriver(String userId);
}
