package com.java.uber.uberApp.entities;

import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.entities.enums.TransactionsType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
@Builder
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionsType transactionsType;

    private TransactionSMethod transactionSMethod;

    @ManyToOne
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @ManyToOne
    private Wallet wallet;
}
