package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
}
