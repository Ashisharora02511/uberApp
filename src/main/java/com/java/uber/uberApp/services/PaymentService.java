package com.java.uber.uberApp.services;

import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {
	void processPayment(Ride ride);
	Payment createNewPayment(Ride ride);
	void updatePaymentStatus(Payment payment,PaymentStatus paymentStatus);
	

}
