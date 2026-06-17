package com.java.uber.uberApp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.java.uber.uberApp.dto.WalletTransactionDto;
import com.java.uber.uberApp.entities.WalletTransactions;
import com.java.uber.uberApp.repositories.WalletTransactionRepository;
import com.java.uber.uberApp.services.WalletTransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletTransactionServicesImpl implements WalletTransactionService {
	
	  private final WalletTransactionRepository walletTransactionRepository;
	  private final ModelMapper mapper;
	
	@Override
	public void createWalletTransaction(WalletTransactionDto walletTransactionDto) {
		
		WalletTransactions walletTransactions=mapper.map(walletTransactionDto, WalletTransactions.class);
		walletTransactionRepository.save(walletTransactions);
	}

}
