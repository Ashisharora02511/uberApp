package com.java.uber.uberApp.strategies;

import com.java.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

  double  RIDE_FARE_MULTIPLIER=10;
    double calculateFare(RideRequest rideRequest);
}
