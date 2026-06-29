package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.config.MapperConfig;
import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.dto.RiderDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.enums.RideRequestStatus;
import com.java.uber.uberApp.entities.enums.RideStatus;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.RideRequestRepository;
import com.java.uber.uberApp.repositories.RiderRepository;
import com.java.uber.uberApp.services.DriverService;
import com.java.uber.uberApp.services.RideService;
import com.java.uber.uberApp.services.RiderService;
import com.java.uber.uberApp.strategies.DriverMatchingStrategy;
import com.java.uber.uberApp.strategies.RideFareCalculationStrategy;
import com.java.uber.uberApp.strategies.RideStrategyManager;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

     final ModelMapper modelMapper;

     private final RideFareCalculationStrategy rideFareCalculationStrategy;

     private final DriverMatchingStrategy driverMatchingStrategy;
     private final RideRequestRepository rideRequestRepository;

     private final RideStrategyManager rideStrategyManager;
     private final RideService rideService;
     private final DriverService driverService;
     private final RiderService riderService;

     private final RiderRepository riderRepository;
    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider=getCurrentRider();
        RideRequest rideRequest=modelMapper.map(rideRequestDto,RideRequest.class);
      rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
      rideRequest.setRider(rider);

      Double fare= rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
         rideRequest.setFare(fare);
       RideRequest savedRideRequest=  rideRequestRepository.save(rideRequest);
       rideStrategyManager.getDriverMatchingStrategy(rider.getRating()).findTenNearestDrivers(rideRequest);

        log.info("request {}", rideRequest.toString());
        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
    	
    	
    	Rider rider=getCurrentRider();
    	Ride ride=rideService.getRideById(rideId);
       if(!rider.equals(ride.getRider())) {
    	   throw new RuntimeException("Rider does not own this ride with id:"+rideId);
    	   
       }
       if(ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
    	   throw new RuntimeException("Ride cannot be cancelled, invalid status:"+ride.getRideStatus());
       }
       Ride updateRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
            driverService.updateDriverAvilabilty(ride.getDriver(), true);
        return modelMapper.map(updateRide, RideDto.class);
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
    public RiderDto getMyProfile() {
    	Rider currentRider= getCurrentRider();
        return modelMapper.map(currentRider, RiderDto.class);
    }

	/*
	 * @Override public Page<RideDto> getMyRide(PageRequest pageRequest) {
	 * 
	 * Rider currentRider= getCurrentRider();
	 * 
	 * return rideService.getAllRidesOfRider(currentRider,
	 * pageRequest).map(ride->modelMapper.map(ride, RideDto.class)); }
	 */

    @Override
    public Rider createNewRider(User user) {

        Rider rider=Rider.builder()
                    .user(user)
                    .rating(0.0)
                    .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1l).orElseThrow(()->new ResourcesNotFoundException("Rider not found with id"+1));
    }

	@Override
	public DriverDto rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
