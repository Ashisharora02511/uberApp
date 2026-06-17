package com.java.uber.uberApp.services.impl;

import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

	@Override
	public void processPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment createNewPayment(Ride ride) {
		// TODO Auto-generated method stub
		return null;
	}

}
