package com.pavyk96.TestGradle.hw10.aspect;

import com.pavyk96.TestGradle.hw10.exeption.RequestLimitExceededException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApiRequestAspect {

    private int requestCount = 0;

    @Value("${api.max-requests}")
    private int maxRequests;

    @Before("execution(public * com.pavyk96.TestGradle.hw10.controller.MessageController.getMessage(..))")
    public void checkRequestCount() {
        if (requestCount >= maxRequests) {
            throw new RequestLimitExceededException("Превышен лимит запросов. Обратитесь к эндпоинту /api/refresh, чтобы сбросить лимит.");
        }
        requestCount++;
    }

    public void resetCounter() {
        requestCount = 0;
    }
}


