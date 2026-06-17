package com.java.uber.uberApp.advices;

import java.time.LocalDateTime;

import lombok.Data;
@Data

public class ApiResponse<T> {


    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;
    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {

        this.data = data;
      ;
    }
    public ApiResponse(LocalDateTime timeStamp, T data, ApiError apiError) {
        this.timeStamp = timeStamp;
        this.data = data;
        this.apiError = apiError;
    }
}
