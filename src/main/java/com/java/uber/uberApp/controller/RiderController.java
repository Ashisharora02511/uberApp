package com.java.uber.uberApp.controller;


import com.java.uber.uberApp.advices.ApiResponse;
import com.java.uber.uberApp.dto.DriverDto;
import com.java.uber.uberApp.dto.RateDto;
import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.dto.RiderDto;
import com.java.uber.uberApp.services.RideService;
import com.java.uber.uberApp.services.RiderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

@RequestMapping("/rider")
@RestController
@RequiredArgsConstructor
public class RiderController {


    private final RiderService riderService;
    @PostMapping("/requestRide")
    public ResponseEntity<ApiResponse<RideRequestDto>>
    requestNewRide(@RequestBody RideRequestDto rideRequestDto) {

        RideRequestDto requestRide =
                riderService.requestRide(rideRequestDto);

        ApiResponse<RideRequestDto> apiResponse =
                new ApiResponse<>(
                        LocalDateTime.now(),
                        requestRide,
                        null
                );

        return ResponseEntity.ok(apiResponse);
   }
    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDto>cancelRide(@PathVariable Long rideId){
    	return ResponseEntity.ok(riderService.cancelRide(rideId));
    }
    
    
    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDto> rateDriver(@RequestBody RateDto rateDto){
    	return ResponseEntity.ok(riderService.rateDriver(rateDto.getRideId(),rateDto.getRating()));
    }
    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDto> getMyProfile(){
    	return ResponseEntity.ok(riderService.getMyProfile());
    	
    }
    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
    		@RequestParam(defaultValue = "10",required = false) Integer pageSize){
    	
    	PageRequest pageRequest=PageRequest.of(pageOffset, pageSize,Sort.by(Sort.Direction.DESC,"createdTime","id"));	
    	
		return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    	
    }
}
