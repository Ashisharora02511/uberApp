package com.java.uber.uberApp.services.impl;

import com.java.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@Primary
public class DistanceServiceOSRMImpl implements DistanceService {

    private  final String OSRM_URL="http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        try{
            String uri=src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
            OSRMResponseDto osrmResponseDto= RestClient
                    .builder()
                    .baseUrl(OSRM_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);


            return osrmResponseDto.getRoutes().get(0).getDistance()/1000.0;

        }catch (Exception e){
            throw  new RuntimeException("Error getting data from OSRM"+e.getMessage());

        }




    }
}
@Data
class OSRMResponseDto{
  List<OSRMRoute> routes;
}
@Data
class OSRMRoute {
    private double distance;
}
