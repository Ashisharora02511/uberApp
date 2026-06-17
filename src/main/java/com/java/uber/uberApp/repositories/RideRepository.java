package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Ride;
import com.java.uber.uberApp.entities.Rider;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {

	Page<Ride> findByRider(Rider rider, PageRequest pageRequest);

	Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
