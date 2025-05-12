package com.pavyk96.TestGradle.service.impl;

import com.pavyk96.TestGradle.service.ItemService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final MeterRegistry meterRegistry;

    @Override
    public String getOrder(String itemName) {
        long start = System.nanoTime();

        meterRegistry.counter("orders.total", "item", itemName).increment();

        meterRegistry.counter("orders.count").increment();

        Timer.builder("orders.execution.time")
                .description("Time to process getOrder")
                .register(meterRegistry)
                .record(System.nanoTime() - start, TimeUnit.NANOSECONDS);

        return "заказ " + itemName + " успешно оформлен!";
    }
}
