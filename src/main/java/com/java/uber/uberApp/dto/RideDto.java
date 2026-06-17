package com.java.uber.uberApp.dto;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.enums.PaymentMethod;
import com.java.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {


    private Long id;


    private PointDto pickupLocation;



    private PointDto dropLocation;


    private LocalDateTime created;


    private RiderDto rider;


    private Driver driver;

    private PaymentMethod paymentMethod;


    private RideStatus rideStatus;
    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
