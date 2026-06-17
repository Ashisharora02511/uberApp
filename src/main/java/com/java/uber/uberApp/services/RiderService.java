package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.dto.RiderDto;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface RiderService {


    RideRequestDto requestRide(RideRequestDto rideRequestDto);


    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    RideDto rateRider(Long rideID);
    RiderDto getMyProfile();
    Page<RideDto> getMyRide(PageRequest pageRequest);
    Rider createNewRider(User user);
    
    Rider getCurrentRider ();
}
