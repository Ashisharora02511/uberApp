package com.java.uber.uberApp.services;

import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.enums.TransactionSMethod;

public interface WalletService {
	
	Wallet addMoneyToWallet(User user,Double amount,String transactionId,Ride ride,TransactionSMethod method);
	void withdrawAllMyMoney();
	Wallet findWalletById(Long walletId);
	Wallet createNewWallet(User user);
	Wallet findByUser(User user); 
	Wallet deductMoneyFromWallet(User user, Double amount,String transactionId,Ride ride,TransactionSMethod transactionSMethod); 

}
