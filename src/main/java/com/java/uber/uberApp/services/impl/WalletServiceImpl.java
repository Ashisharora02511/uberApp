package com.java.uber.uberApp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.WalletTransactionDto;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.WalletTransactions;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.WalletRepository;
import com.java.uber.uberApp.services.WalletService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class WalletServiceImpl  implements WalletService{
	private final WalletRepository walletRepository;
	private final ModelMapper mapper;
	

	@Override
	public Wallet addMoneyToWallet(User user, Double amount,String transactionId,Ride ride) {
		Wallet wallet =findByUser(user);
		
		wallet.setBalance(wallet.getBalance()+amount);
		
		/*
		 * WalletTransactions walletTransactionDto=WalletTransactions.builder()
		 * .transactionId(transactionId) .ride(ride) .wallet(wallet);
		 */
		
		return walletRepository.save(wallet);
	}

	@Override
	public void withdrawAllMyMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wallet findWalletById(Long walletId) {
		// TODO Auto-generated method stub
		return walletRepository.findById(walletId).orElseThrow(()->new ResourcesNotFoundException("Wallet NOt found with given id"+walletId));
	}

	@Override
	public Wallet createNewWallet(User user) {
		
		
		Wallet wallet=new Wallet();
		wallet.setUser(user);
		wallet.setBalance(0.0);
	
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet findByUser(User user) {
	
		return walletRepository.findByUser(user).orElseThrow(()->new ResourcesNotFoundException("Wallet not found for user with id"+user));
	}

	@Override
	public Wallet deductMoneyFromWallet(User user, Double amount) {
		Wallet wallet =findByUser(user);
		
		wallet.setBalance(wallet.getBalance()-amount);
		
		return walletRepository.save(wallet);
	}

}
