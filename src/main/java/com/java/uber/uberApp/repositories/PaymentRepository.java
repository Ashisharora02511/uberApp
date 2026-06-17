package com.java.uber.uberApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uber.uberApp.entities.Payment;
import com.java.uber.uberApp.entities.Ride;
@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Long>{

	Optional<Payment> findByRide(Ride ride);

}
