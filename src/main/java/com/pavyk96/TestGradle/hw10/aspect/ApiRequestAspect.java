package com.pavyk96.TestGradle.hw10.aspect;

import com.pavyk96.TestGradle.hw10.annotation.RateLimited;
import com.pavyk96.TestGradle.hw10.exeption.RequestLimitExceededException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
public class ApiRequestAspect {

    @Value("${api.max-requests}")
    private int maxRequests;

    // Потокобезопасная мапа для счетчиков по каждому методу
    private final Map<String, AtomicInteger> requestCounters = new ConcurrentHashMap<>();

    @Before("within(com.pavyk96.TestGradle.hw10.controller..*) && execution(public * *(..))")
    public void checkRequestCount(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> declaringClass = signature.getDeclaringType();

        boolean isRateLimited =
                method.isAnnotationPresent(RateLimited.class) ||
                        declaringClass.isAnnotationPresent(RateLimited.class);

        if (isRateLimited) {
            String methodKey = declaringClass.getName() + "#" + method.getName();
            requestCounters.putIfAbsent(methodKey, new AtomicInteger(0));

            int currentCount = requestCounters.get(methodKey).incrementAndGet();
            if (currentCount > maxRequests) {
                throw new RequestLimitExceededException(
                        "Превышен лимит запросов для метода " + method.getName() +
                                ". Обратитесь к эндпоинту /api/refresh, чтобы сбросить лимит.");
            }
        }
    }

    public void resetCounters() {
        requestCounters.clear();
    }
}
