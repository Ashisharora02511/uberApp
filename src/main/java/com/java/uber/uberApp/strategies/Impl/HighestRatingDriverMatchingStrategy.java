package com.java.uber.uberApp.strategies.Impl;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.repositories.DriverRepository;
import com.java.uber.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Primary
public class HighestRatingDriverMatchingStrategy implements DriverMatchingStrategy {
    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findTenNearestDrivers(RideRequest rideRequest) {


        return driverRepository.findTenNearByTopRatedDrivers(rideRequest.getPickupLocation());
    }


}
