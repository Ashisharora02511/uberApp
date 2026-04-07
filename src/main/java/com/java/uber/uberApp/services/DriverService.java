package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RiderDto;

import java.util.List;

public interface DriverService {

    RideDto cancelRide(Long rideId);



    DriverDto rateDriver(Long rideID);
    RiderDto getMyProfile();
    List<RideDto> getMyRides();

}
