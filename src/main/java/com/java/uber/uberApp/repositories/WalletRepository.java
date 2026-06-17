package com.java.uber.uberApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.uber.uberApp.entities.User;
import com.java.uber.uberApp.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Long>{

	Optional<Wallet> findByUser(User user);

}
