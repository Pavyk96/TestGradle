package com.pavyk96.TestGradle.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id = "logtime")
public class TimeLogEndpoint {

    @ReadOperation
    public String logTime() {
        String message = "Вызов актуатора: " + LocalDateTime.now();
        System.out.println(message);
        return message;
    }
}

