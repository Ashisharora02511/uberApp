package com.java.uber.uberApp.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.java.uber.uberApp.exceptions.BadCredentialsException;
import com.java.uber.uberApp.exceptions.ResourcesNotFoundException;
import com.java.uber.uberApp.exceptions.RuntimeConflictExceptions;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
public ResponseEntity<ApiResponse<?>> handleResourcesNotFoundException(ResourcesNotFoundException exception){

        ApiError apiError=ApiError.builder().httpStatus(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();

        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(RuntimeConflictExceptions.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictExceptions exception){

        ApiError apiError=ApiError.builder().httpStatus(HttpStatus.CONFLICT).message(exception.getMessage()).build();

        return buildErrorResponseEntity(apiError);
    }







    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<?>> handleBadException(BadCredentialsException exception){

        ApiError apiError=ApiError.builder().httpStatus(HttpStatus.BAD_REQUEST).message(exception.getMessage()).build();

        return new  ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception exception){

        ApiError apiError=ApiError.builder().httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build();

        return buildErrorResponseEntity(apiError);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Input validation failed")
                .subErrors(errors)
                .build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getHttpStatus());
    }


}
