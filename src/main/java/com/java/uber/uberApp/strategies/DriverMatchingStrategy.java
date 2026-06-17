package com.java.uber.uberApp.strategies;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findTenNearestDrivers(RideRequest rideRequestDto);

}
