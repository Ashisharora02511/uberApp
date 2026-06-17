package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);
    void MatchWithDrivers(RideRequestDto rideRequestDto);
    Ride createdNewRide(RideRequest rideRequestDto, Driver driver);
    Ride updateRideStatus(Ride ride, RideStatus rideStatus);
    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);
    Page<Ride> getAllRidesOfDriver(Driver driver,PageRequest pageRequest);
}
