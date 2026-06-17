package com.java.uber.uberApp.utils;

import com.java.uber.uberApp.dto.PointDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeometryUtil {


    public static Point createPoint(PointDto pointDto){




        GeometryFactory factory=new GeometryFactory(new PrecisionModel(),4326);
        Coordinate coordinate=new Coordinate(pointDto.getCoordinate()[0],pointDto.getCoordinate()[1]);
        return factory.createPoint(coordinate);
    }


}
