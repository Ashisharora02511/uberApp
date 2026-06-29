package com.java.uber.uberApp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RateDto {
	
	private Long rideId;
	private Integer rating;
	

}
