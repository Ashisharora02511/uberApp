package com.java.uber.uberApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uber.uberApp.entities.Payment;
@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Long>{

}
