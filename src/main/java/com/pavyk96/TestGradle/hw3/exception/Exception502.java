package com.pavyk96.TestGradle.hw3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Exception502 {

    @ExceptionHandler(BadGatewayException.class)
    public ResponseEntity<ErrorResponse> handleBadGatewayException(BadGatewayException exception) {
        ErrorResponse errorResponse = new ErrorResponse(502, "Сервер недоступен: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    public record ErrorResponse(int status, String message) {}
}
