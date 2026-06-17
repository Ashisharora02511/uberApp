package com.java.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {
    double[] coordinate;
    private String type="Point";

    public PointDto(double[] coordinates) {
        this.coordinate=coordinates;
    }
}
