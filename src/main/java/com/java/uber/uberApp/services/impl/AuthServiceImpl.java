package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.SignupDto;
import com.java.uber.uberApp.dto.UserDto;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.enums.Role;
import com.java.uber.uberApp.exceptions.RuntimeConflictExceptions;
import com.java.uber.uberApp.repositories.UserRepository;
import com.java.uber.uberApp.services.AuthService;
import com.java.uber.uberApp.services.RiderService;
import com.java.uber.uberApp.services.WalletService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final RiderService riderService;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final WalletService walletService;
    @Override
    public void login(String email, String password) {

    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        //check user alredy existing using email
        User user=userRepository.findByEmail(signupDto.getEmail()).orElse(null);

      if(user !=null){
           throw  new RuntimeConflictExceptions("Cannot signup, User alredy exists with email +signupDto.getEmail()");
        }


       User mappedUser=mapper.map(signupDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
       User savedUser= userRepository.save(mappedUser);
       //create user related entities
        Rider rider=riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);
        //add wallet related services here
        return mapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(String userId) {
        return null;
    }
}
