package com.java.uber.uberApp.strategies.Impl;

import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.services.DistanceService;
import com.java.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RideFareSurgePricingCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    @Override
    public double calculateFare(RideRequest rideRequest) {
       double distance=distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropLocation());

      return distance*RIDE_FARE_MULTIPLIER;
    }
}
