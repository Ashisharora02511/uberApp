package com.java.uber.uberApp.services;

import com.java.uber.uberApp.entities.RideRequest;

public interface RideRequestService {
	
	RideRequest findRequestById(Long rideRequestId);

	void update(RideRequest rideRequest);



}
