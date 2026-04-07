package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {
}
