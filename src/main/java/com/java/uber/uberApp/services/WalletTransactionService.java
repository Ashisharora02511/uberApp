package com.java.uber.uberApp.services;

import com.java.uber.uberApp.dto.WalletTransactionDto;
import com.java.uber.uberApp.entities.WalletTransactions;

public interface WalletTransactionService {
	
	
	void createWalletTransaction(WalletTransactions walletTransactionDto);

}
