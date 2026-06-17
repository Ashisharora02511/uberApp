package com.java.uber.uberApp.services;

import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.Wallet;

public interface WalletService {
	
	Wallet addMoneyToWallet(User user,Double amount,String transactionId,Ride ride);
	void withdrawAllMyMoney();
	Wallet findWalletById(Long walletId);
	Wallet createNewWallet(User user);
	Wallet findByUser(User user); 
	Wallet deductMoneyFromWallet(User user,Double amount); 

}
