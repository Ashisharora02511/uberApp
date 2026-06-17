package com.java.uber.uberApp.config;

import com.java.uber.uberApp.dto.PointDto;
import com.java.uber.uberApp.utils.GeometryUtil;

import org.locationtech.jts.geom.Point;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    ModelMapper modelMapper(){

    ModelMapper modelMapper= new ModelMapper();
    modelMapper.typeMap(PointDto.class, Point.class).setConverter(converter->{
        PointDto pointDt=converter.getSource();
   return GeometryUtil.createPoint(pointDt);

    });

    modelMapper.typeMap(Point.class,PointDto.class).setConverter(context->{
        Point point=context.getSource();
                double coordinates[]={
                        point.getX(),
                        point.getY()
        };

  return  new PointDto(coordinates);
    });
   return modelMapper;
    }
}
