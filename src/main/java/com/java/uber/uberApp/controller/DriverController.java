package com.java.uber.uberApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideStartDto;
import com.java.uber.uberApp.services.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
	
	
	private final DriverService driverService;
	
	
	@PostMapping("/acceptRide/{rideRequestId}")
	public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestId){
		
		
		return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
		
	}
	
	
	@PostMapping("/startRide/{rideRequestId}")
	public ResponseEntity<RideDto> starttRide(@PathVariable Long rideRequestId,@RequestBody RideStartDto dto){
		
		
		return ResponseEntity.ok(driverService.startRide(rideRequestId,dto.getOtp()));
		
	}

}
