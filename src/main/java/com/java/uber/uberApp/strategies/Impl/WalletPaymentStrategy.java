package com.java.uber.uberApp.strategies.Impl;

import org.springframework.stereotype.Service;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.services.WalletService;
import com.java.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

	private final WalletService service;
	
	@Override
	public void processPayment(Payment payment) {
	Driver driver=payment.getRide().getDriver();
	Wallet	 driverWallet= service.findByUser(driver.getUser());
	double palteformcommission=payment.getAmount()*PLATEFORM_COMMISSION;
	service.deductMoneyFromWallet(driver.getUser(), palteformcommission);

	}

}
