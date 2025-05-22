package com.pavyk96.TestGradle.hw10.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestLimitExceededException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS) // 429
    public Map<String, String> handleLimitExceeded(RequestLimitExceededException ex) {
        return Map.of(
                "error", "Too Many Requests",
                "message", ex.getMessage()
        );
    }
}

