package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository  extends JpaRepository<Rider,Long> {
}
