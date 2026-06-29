package com.java.uber.uberApp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RateDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideStartDto;
import com.java.uber.uberApp.dto.RiderDto;
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
	@PostMapping("/endRide/{rideId}")
	public ResponseEntity<RideDto> endRide(@PathVariable Long rideId){
		
		
		return ResponseEntity.ok(driverService.endRide(rideId));
		
	}
	
	
	
	
	   @PostMapping("/cancelRide/{rideId}")
	    public ResponseEntity<RideDto>cancelRide(@PathVariable Long rideId){
	    	return ResponseEntity.ok(driverService.cancelRide(rideId));
	    }
	    
	    
	    @PostMapping("/rateRider")
	    public ResponseEntity<RiderDto> rateRider(@RequestBody RateDto rateDto){
	    	return ResponseEntity.ok(driverService.rateRider(rateDto.getRideId(),rateDto.getRating()));
	    }
	    @GetMapping("/getMyProfile")
	    public ResponseEntity<DriverDto> getMyProfile(){
	    	return ResponseEntity.ok(driverService.getMyProfile());
	    	
	    }
	    @GetMapping("/getMyRides")
	    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
	    		@RequestParam(defaultValue = "10",required = false) Integer pageSize){
	    	
	    	PageRequest pageRequest=PageRequest.of(pageOffset, pageSize,Sort.by(Sort.Direction.DESC,"createdTime","id"));	
	    	
			return ResponseEntity.ok(driverService.getAllMyRides(pageRequest));
	    	
	    }
}
