package com.java.uber.uberApp.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.enums.PaymentStatus;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.PaymentRepository;
import com.java.uber.uberApp.services.PaymentService;
import com.java.uber.uberApp.strategies.PaymentStrategyManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
	
	
	private final PaymentRepository paymentRepository;
	private final PaymentStrategyManager paymentStrategyManager;
	

	@Override
	public void processPayment(Ride ride) {

		Payment payment=paymentRepository.findByRide(ride).orElseThrow(()->new ResourcesNotFoundException("Payment not found for ride with ride : "+ride.getId()));
		
		paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
		
	}

	@Override
	public Payment createNewPayment(Ride ride) {
		
		
		Payment paymeny=Payment.builder()
				
		     .ride(ride)
		     .paymentMethod(ride.getPaymentMethod())
		     .amount(ride.getFare())
		     .paymentStatus(PaymentStatus.PENDING)
		     .build();
		return paymentRepository.save(paymeny);
	}

	@Override
	public void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus) {
		payment.setPaymentStatus(paymentStatus);
		paymentRepository.save(payment);	
		
	}

}
