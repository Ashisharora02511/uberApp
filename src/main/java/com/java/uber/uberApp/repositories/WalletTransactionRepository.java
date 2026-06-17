package com.java.uber.uberApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uber.uberApp.entities.WalletTransactions;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransactions,Long>{

}
