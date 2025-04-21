package com.pavyk96.TestGradle.hw9.dto;

public record Message() {
    public record SimpleEvent(String message) {}
    public record AsyncEvent(String message) {}
    public record TxEvent(String message, boolean shouldProcess) {}
}
