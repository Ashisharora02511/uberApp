package com.java.uber.uberApp.strategies;

import com.java.uber.uberApp.entities.Payment;

public interface PaymentStrategy {
	
	static final Double PLATEFORM_COMMISSION=0.3;
	
	void processPayment(Payment payment);

}
