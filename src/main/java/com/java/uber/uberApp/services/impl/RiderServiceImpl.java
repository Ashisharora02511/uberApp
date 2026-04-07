package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.services.RiderService;

import java.util.List;

public class RiderServiceImpl implements RiderService {
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto rateRider(Long rideID) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getMyRide() {
        return null;
    }
}
