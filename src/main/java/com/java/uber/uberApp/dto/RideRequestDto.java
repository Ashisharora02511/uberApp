package com.java.uber.uberApp.dto;

import com.java.uber.uberApp.entities.Driver;
import com.java.uber.uberApp.entities.Rider;
import com.java.uber.uberApp.entities.enums.PaymentMethod;
import com.java.uber.uberApp.entities.enums.RideRequestStatus;
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
public class RideRequestDto {

    private Long id;


    private PointDto pickupLocation;



    private PointDto dropLocation;


    private LocalDateTime requestTime;


    private Rider rider;


    private PaymentMethod paymentMethod;
    
    private Double fare; 


    private RideRequestStatus rideRequestStatus;

}
