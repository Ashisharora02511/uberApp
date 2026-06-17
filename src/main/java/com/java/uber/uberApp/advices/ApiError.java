package com.java.uber.uberApp.advices;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@Data
public class ApiError {

    HttpStatus httpStatus;
    String message;
    private List<String> subErrors;
}
