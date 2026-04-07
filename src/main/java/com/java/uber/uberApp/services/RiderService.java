package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface RiderService {


    RideRequestDto requestRide(RideRequestDto rideRequestDto);


    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    RideDto rateRider(Long rideID);
    DriverDto getMyProfile();
    List<RideDto> getMyRide();
}
