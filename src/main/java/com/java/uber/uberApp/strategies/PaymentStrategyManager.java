package com.java.uber.uberApp.strategies;

import org.springframework.stereotype.Component;

import com.java.uber.uberApp.entities.enums.PaymentMethod;
import com.java.uber.uberApp.strategies.Impl.CODPaymentStrategy;
import com.java.uber.uberApp.strategies.Impl.WalletPaymentStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {
	
	
	private final WalletPaymentStrategy walletPaymentStrategy;
	private final CODPaymentStrategy codPaymentStrategy;
	
	
	public PaymentStrategy paymentStrategy(PaymentMethod method) {
		
		
		return switch (method) {
		case WALLET -> walletPaymentStrategy;
		case CASH -> codPaymentStrategy;
		default -> throw new RuntimeException("Invalid Payment method");
		};
		
	}
	
	

}
