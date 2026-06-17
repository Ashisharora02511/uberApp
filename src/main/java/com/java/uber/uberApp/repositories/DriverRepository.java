package com.java.uber.uberApp.repositories;

import com.java.uber.uberApp.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query(value = "Select d.*,ST_Distance(d.current_location,:pickupLocation) AS distance " +
            " FROM drivers  d " +
            "where available = true AND ST_DWithin(d.current_location,:pickupLocation,10000) " +
            "ORDER BY distance " +
            "LIMIT 10 ",nativeQuery = true)
    List<Driver> findTenNearestDrivers(Point pickupLocation);

    //task to add get the driver that top rated in nearest 5km area


    @Query(value="Select d.* " +
                  " from drivers d " +
                  " WHERE d.available =true AND ST_DWithin(d.current_location,:pickupLocation, 15000)" +
                  " ORDER BY d.rating DESC " +
                  " LIMIT 10 ",nativeQuery = true)
    List<Driver> findTenNearByTopRatedDrivers(Point pickupLocation);

}
