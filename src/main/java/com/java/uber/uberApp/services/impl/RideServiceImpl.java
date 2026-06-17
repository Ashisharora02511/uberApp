package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.enums.RideRequestStatus;
import com.java.uber.uberApp.entities.enums.RideStatus;
import com.java.uber.uberApp.repositories.RideRepository;
import com.java.uber.uberApp.services.RideRequestService;
import com.java.uber.uberApp.services.RideService;

import lombok.RequiredArgsConstructor;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {
	
	private final RideRepository repository;
	
	private final RideRequestService requestService;
	
	private final ModelMapper mapper;


    @Override
    public Ride getRideById(Long rideId) {
    	
    	
        return repository.findById(rideId).orElseThrow(()-> new RuntimeException("Ride not found with id:"+rideId));
    }

    @Override
    public void MatchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createdNewRide(RideRequest rideRequest, Driver driver) {
    	
    	
    	rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
    	Ride ride=mapper.map(rideRequest, Ride.class);
    	ride.setRideStatus(RideStatus.CONFIRMED);
    	ride.setDriver(driver);
    	ride.setOtp(getrateRandomOtp());
    	ride.setId(null);
    	ride.setPickupLocation(rideRequest.getPickupLocation());
    	requestService.update(rideRequest);
    	
    	
    	
        return repository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
    	ride.setRideStatus(rideStatus);
    	Ride saveRide = repository.save(ride);
    	
    	
    	
    	
    	
    	
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return repository.findByRider(rider,pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) { 
        return repository.findByDriver(driver,pageRequest);
    }
    
    
    public String getrateRandomOtp() {
    	Random random=new Random();
    	int otpInt=random.nextInt(10000);
    	return String.format("%04d",otpInt);
    }
}
