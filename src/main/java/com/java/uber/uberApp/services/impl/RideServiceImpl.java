package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.enums.RideStatus;
import com.java.uber.uberApp.services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class RideServiceImpl implements RideService {


    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void MatchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createdNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
