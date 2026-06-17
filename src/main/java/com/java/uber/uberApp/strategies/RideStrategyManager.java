package com.java.uber.uberApp.strategies;

import com.java.uber.uberApp.strategies.Impl.DefaultRideFareCalculationStrategy;
import com.java.uber.uberApp.strategies.Impl.DrivermatchingStrategyNearestDriver;
import com.java.uber.uberApp.strategies.Impl.HighestRatingDriverMatchingStrategy;
import com.java.uber.uberApp.strategies.Impl.RideFareSurgePricingCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager  {


    private final HighestRatingDriverMatchingStrategy highestRatingDriverMatchingStrategy;
    private final DrivermatchingStrategyNearestDriver drivermatchingStrategyNearestDriver;
    private final RideFareSurgePricingCalculationStrategy rideFareSurgePricingCalculationStrategy;
    private final DefaultRideFareCalculationStrategy defaultRideFareCalculationStrategy;


    public DriverMatchingStrategy getDriverMatchingStrategy (double riderRating){
        if(riderRating>4.8){
            return highestRatingDriverMatchingStrategy;
        }
        else {
            return  drivermatchingStrategyNearestDriver;
        }
    }
    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime surgeStartTime=LocalTime.of(18,0);
        LocalTime surgeEndTime=LocalTime.of(18,0);
        LocalTime currentTime=LocalTime.now();
        boolean surgeTime=currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if (surgeTime){
            return rideFareSurgePricingCalculationStrategy;
        }
        else {
            return  defaultRideFareCalculationStrategy;
        }
    }

}
