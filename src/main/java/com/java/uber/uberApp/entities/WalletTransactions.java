package com.java.uber.uberApp.entities;

import com.java.uber.uberApp.entities.enums.TransactionSMethod;
import com.java.uber.uberApp.entities.enums.TransactionsType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionsType transactionsType;

    private TransactionSMethod transactionSMethod;
}
