package com.java.uber.uberApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.uber.uberApp.dto.DriverDto;
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
   ResponseEntity< UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto),HttpStatus.CREATED);
    }
    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId,@RequestParam String vehicleId){
    	
    	return new ResponseEntity<>(authService.onboardNewDriver(userId,vehicleId),HttpStatus.CREATED);
    	
    }
    

}