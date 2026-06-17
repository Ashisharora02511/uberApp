package com.java.uber.uberApp.services;

import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Ride;

public interface PaymentService {
	void processPayment(Payment payment);
	Payment createNewPayment(Ride ride);

}
