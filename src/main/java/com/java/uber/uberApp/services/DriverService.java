package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RiderDto;
import com.java.uber.uberApp.entities.Driver;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DriverService {

    RideDto cancelRide(Long rideId);



    DriverDto rateDriver(Long rideID);
   // RiderDto getMyProfile();
    Page<RideDto> getAllMyRides(PageRequest pageRequest);
    RideDto startRide(Long rideId,String otp);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId,Integer rating);
    DriverDto getMyProfile();
    
    



	RideDto acceptRide(Long rideRequestId);
    Driver getCurrentDriver();
    Driver updateDriverAvilabilty(Driver driver,boolean avilable);
    
    Driver createNewDriver(Driver driver);
}
