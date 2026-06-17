package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {


        //call the third party api called OSRM to fetch the distance

        return 0;
    }
}
