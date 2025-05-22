package com.pavyk96.TestGradle.hw10.exeption;

public class RequestLimitExceededException extends RuntimeException {
    public RequestLimitExceededException(String message) {
        super(message);
    }
}

