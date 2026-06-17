package com.java.uber.uberApp.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.Wallet;
import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.entities.enums.TransactionsType;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@Builder
public class WalletTransactionDto {
	
	
	
	
    private Long id;
    private Double amount;

    private TransactionsType transactionsType;

    private TransactionSMethod transactionSMethod;

  
    private RideDto ride;

    private String transactionId;

  
    private LocalDateTime timeStamp;

  
    private WalletDto wallet;

}
