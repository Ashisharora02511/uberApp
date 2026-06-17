package com.java.uber.uberApp.strategies.Impl;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.repositories.DriverRepository;
import com.java.uber.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class DrivermatchingStrategyNearestDriver implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findTenNearestDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}



