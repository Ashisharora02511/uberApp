package com.java.uber.uberApp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.uber.uberApp.dto.RideDto;
import com.java.uber.uberApp.dto.WalletTransactionDto;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.WalletTransactions;
import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.entities.enums.TransactionsType;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.repositories.WalletRepository;
import com.java.uber.uberApp.services.WalletService;
import com.java.uber.uberApp.services.WalletTransactionService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class WalletServiceImpl  implements WalletService{
	private final WalletRepository walletRepository;
	private final WalletTransactionService transactionService;
	private final ModelMapper mapper;
	

	@Override
	@Transactional
	public Wallet addMoneyToWallet(User user, Double amount,String transactionId,Ride ride,TransactionSMethod transactionSMethod) {
		Wallet wallet =findByUser(user);
		
		wallet.setBalance(wallet.getBalance()+amount);
		
		
		  WalletTransactions walletTransaction=WalletTransactions.builder()
		  .transactionId(transactionId) 
		  .ride(ride)
		  .wallet(wallet)
		  .transactionsType(TransactionsType.CREDIT)
          .transactionSMethod(transactionSMethod)
          .amount(amount)
          . build();
		  transactionService.createWalletTransaction(walletTransaction);
		
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
	@Transactional
	public Wallet deductMoneyFromWallet(User user, Double amount,String transactionId,Ride ride,TransactionSMethod transactionSMethod) {
		Wallet wallet =findByUser(user);
		
		wallet.setBalance(wallet.getBalance()-amount);
		
		
		  WalletTransactions walletTransaction=WalletTransactions.builder()
				  .transactionId(transactionId) 
				  .ride(ride)
				  .wallet(wallet)
				  .transactionsType(TransactionsType.DEBIT)
		          .transactionSMethod(transactionSMethod)
		          .amount(amount)
		          . build();
		//  transactionService.createWalletTransaction(walletTransaction);
			wallet.getTransactions().add(walletTransaction);
		
		return walletRepository.save(wallet);
	}

}
