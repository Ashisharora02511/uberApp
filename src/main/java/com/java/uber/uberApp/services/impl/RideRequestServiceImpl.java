package com.java.uber.uberApp.services.impl;

import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.RideRequest;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.RideRequestRepository;
import com.java.uber.uberApp.services.RideRequestService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

	
	private final RideRequestRepository rideRepository;
	
	@Override
	public RideRequest findRequestById(Long rideRequestId) {
		// TODO Auto-generated method stub
		return rideRepository.findById(rideRequestId).orElseThrow(()-> new ResourcesNotFoundException("Ride Request not found with id"+rideRequestId));
	}

	@Override
	public void update(RideRequest rideRequest) {
		
		rideRepository.findById(rideRequest.getId()).orElseThrow(()->new ResourcesNotFoundException("Ride Request not found with id"+rideRequest.getId()));
		rideRepository.save(rideRequest);
		
		
	}

}
