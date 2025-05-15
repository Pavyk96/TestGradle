package com.pavyk96.TestGradle.service.impl;

import com.pavyk96.TestGradle.service.ItemService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final MeterRegistry meterRegistry;
    private Counter totalOrdersCounter;
    private Counter generalOrdersCounter;
    private Timer executionTimer;

    @PostConstruct
    public void init() {
        this.totalOrdersCounter = Counter.builder("orders.total")
                .description("Total orders by item")
                .register(meterRegistry);

        this.generalOrdersCounter = Counter.builder("orders.count")
                .description("Total orders count")
                .register(meterRegistry);

        this.executionTimer = Timer.builder("orders.execution.time")
                .description("Time to process getOrder")
                .publishPercentiles(0.5, 0.95)
                .register(meterRegistry);
    }

    @Override
    public String createOrder(String itemName) {
        return executionTimer.record(() -> {
            generalOrdersCounter.increment();
            totalOrdersCounter.increment();

            return "Заказ " + itemName + " успешно создан!";
        });
    }
}
