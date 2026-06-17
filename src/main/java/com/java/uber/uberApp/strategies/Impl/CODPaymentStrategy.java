package com.java.uber.uberApp.strategies.Impl;

import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.enums.PaymentStatus;
import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.repositories.PaymentRepository;
import com.java.uber.uberApp.services.PaymentService;
import com.java.uber.uberApp.services.WalletService;
import com.java.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CODPaymentStrategy  implements PaymentStrategy{
	private final WalletService service;
    
    private final PaymentRepository paymentRepository;
	@Override
	public void processPayment(Payment payment) {
		Driver diver=payment.getRide().getDriver();
		
		
		Wallet deriverWallet=service.findByUser(diver.getUser());
		double paltfromCommission=payment.getAmount()*PLATEFORM_COMMISSION;
		service.deductMoneyFromWallet(diver.getUser(), paltfromCommission, null, payment.getRide(), TransactionSMethod.RIDE);
		payment.setPaymentStatus(PaymentStatus.CONFIRMED);
		paymentRepository.save(payment);
		// paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);
		
	}

}
