package com.java.uber.uberApp.strategies.Impl;

import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.enums.PaymentStatus;
import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.repositories.PaymentRepository;
import com.java.uber.uberApp.services.WalletService;
import com.java.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

	private final WalletService walletService;
	private final PaymentRepository paymentRepository;
	
	@Override
	public void processPayment(Payment payment) {
	Driver driver=payment.getRide().getDriver();
	Rider rider=payment.getRide().getRider();
	
	walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), null, payment.getRide(), TransactionSMethod.RIDE);
	double driverCuts=payment.getAmount()*(1-PLATEFORM_COMMISSION);
	
	walletService.addMoneyToWallet(driver.getUser(),driverCuts, null, payment.getRide(), TransactionSMethod.RIDE);
	payment.setPaymentStatus(PaymentStatus.CONFIRMED);
	paymentRepository.save(payment);
	
	

	}

}
