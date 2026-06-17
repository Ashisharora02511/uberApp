package com.java.uber.uberApp.entities;

import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.entities.enums.TransactionsType;
import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionsType transactionsType;

    private TransactionSMethod transactionSMethod;

    @OneToOne
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @ManyToOne
    private Wallet wallet;
}
