package com.java.uber.uberApp.controller;


import com.java.uber.uberApp.advices.ApiResponse;
import com.java.uber.uberApp.dto.RideRequestDto;
import com.java.uber.uberApp.services.RideService;
import com.java.uber.uberApp.services.RiderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rider")
@RestController
@RequiredArgsConstructor
public class RiderController {


    private final RiderService rideService;
    @PostMapping("/requestRide")
    public ResponseEntity<ApiResponse<RideRequestDto>>
    requestNewRide(@RequestBody RideRequestDto rideRequestDto) {

        RideRequestDto requestRide =
                rideService.requestRide(rideRequestDto);

        ApiResponse<RideRequestDto> apiResponse =
                new ApiResponse<>(
                        LocalDateTime.now(),
                        requestRide,
                        null
                );

        return ResponseEntity.ok(apiResponse);
   }
}
