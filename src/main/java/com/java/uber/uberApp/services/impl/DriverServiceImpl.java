package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RiderDto;
import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.entities.enums.RideRequestStatus;
import com.java.uber.uberApp.entities.enums.RideStatus;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.DriverRepository;
import com.java.uber.uberApp.services.DriverService;
import com.java.uber.uberApp.services.PaymentService;
import com.java.uber.uberApp.services.RideRequestService;
import com.java.uber.uberApp.services.RideService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
	
	private static final Object RideDto = null;
	private final RideRequestService requestService;
	private final DriverRepository driverRepository;
	private final RideService rideService;
	private final ModelMapper mapper;
	private final PaymentService paymentService;
	
	 
    @Override
    public RideDto cancelRide(Long rideId) {
    	
    	Ride ride=rideService.getRideById(rideId);
		Driver driver=getCurrentDriver();
		if(!driver.equals(ride.getDriver())) {
			throw new RuntimeException("Driver cannnot start a ride and he has not accepted  it eariler");
			
		}
    	
		if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
			throw new RuntimeException("Ride Cannot be cancelled,invalid status: "+ride.getRideStatus());
			
		}
		rideService.updateRideStatus(ride, RideStatus.CANCELLED);
		
		updateDriverAvilabilty(driver, true);
		//driver.setAvailable(true);
		driverRepository.save(driver);
    	
    	
        return mapper.map(ride, RideDto.class);
    }

    @Override
    public DriverDto rateDriver(Long rideID) {
        return null;
    }

  

	@Override
	public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
		Driver currentDriver=getCurrentDriver();
		return rideService.getAllRidesOfDriver(currentDriver, pageRequest).map(ride->mapper.map(ride,RideDto.class));
		
		
	}

	@Override
	public RideDto startRide(Long rideId,String otp) {
		
		
		Ride ride=rideService.getRideById(rideId);
		Driver driver=getCurrentDriver();
		if(!driver.equals(ride.getDriver())) {
			throw new RuntimeException("Driver cannnot start a ride and he has not accepted  it eariler");
			
		}
		if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
			throw new RuntimeException("Ride status cnnnot confirmed hence cannot started,Status;"+ride.getRideStatus());
		}
		if(!otp.equals(ride.getOtp())){
			throw new RuntimeException("Otp is not valid,otp"+otp);
		}
		ride.setStartedAt(LocalDateTime.now());
		Ride updateRideStatus = rideService.updateRideStatus(ride, RideStatus.ONGOING);
	
		paymentService.createNewPayment(updateRideStatus);
		
		

		return mapper.map(updateRideStatus, RideDto.class);
	}

	@Override
	@Transactional
	public RideDto endRide(Long rideId) {
		Ride ride=rideService.getRideById(rideId);
		Driver driver=getCurrentDriver();
		if(!driver.equals(ride.getDriver())) {
			throw new RuntimeException("Driver cannnot start a ride and he has not accepted  it eariler");
			
		}
		if(!ride.getRideStatus().equals(RideStatus.ONGOING)) {
			throw new RuntimeException("Ride status is not ONGOING hence cannot be ended ,Status;"+ride.getRideStatus());
		}
		ride.setEndedAt(LocalDateTime.now());
		Ride updateRideStatus = rideService.updateRideStatus(ride, RideStatus.ENDED);
		updateDriverAvilabilty(driver, true);
		return mapper.map(updateRideStatus, RideDto.class);
	}

	@Override
	public RideDto rateRider(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RideDto acceptRide(Long rideRequestId) {
	 RideRequest rideRequest=requestService.findRequestById(rideRequestId);
	 
	 if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
		   
		 throw new RuntimeException("Ride Request cannot be accepted, status is"+rideRequest.getRideRequestStatus());
	 }
	 
	 
	 Driver driver=getCurrentDriver();
	 if(!driver.getAvailable()) {
		 throw new RuntimeException("Driver cannot accept ride due to unavialblity");
	 }
	 
	
	Driver driverSaved=updateDriverAvilabilty(driver, false);
	 Driver savedDriver = driverRepository.save(driver);
	 Ride createdNewRide = rideService.createdNewRide(rideRequest, savedDriver);
	 RideDto map = mapper.map(createdNewRide, RideDto.class);
	 
	 
		return map;
	}

	@Override
	public DriverDto getMyProfile() {
	 Driver currentDriver=getCurrentDriver();
		return mapper.map(currentDriver, DriverDto.class);
	}

	@Override
	public Driver getCurrentDriver() {
		// TODO Auto-generated method stub
		return driverRepository.findById(2l).orElseThrow(()->new ResourcesNotFoundException("Driver not found with id"+2));
	}

	@Override
	public Driver updateDriverAvilabilty(Driver driver, boolean avilable) {
	  
	   driver.setAvailable(avilable);
	   Driver save = driverRepository.save(driver);
	   
	return save;
		
	}
}
