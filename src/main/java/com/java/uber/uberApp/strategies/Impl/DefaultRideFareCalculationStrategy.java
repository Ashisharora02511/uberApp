package com.java.uber.uberApp.strategies.Impl;

import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.services.DistanceService;
import com.java.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class DefaultRideFareCalculationStrategy implements RideFareCalculationStrategy {


    private final DistanceService distanceService;

    private static final double SURGE_FACTOR=2;
    @Override
    public double calculateFare(RideRequest rideRequest) {

        Double distance=distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropLocation());


        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}
