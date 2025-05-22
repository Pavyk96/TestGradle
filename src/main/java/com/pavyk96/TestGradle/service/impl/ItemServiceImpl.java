package com.pavyk96.TestGradle.service.impl;

import com.pavyk96.TestGradle.service.ItemService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final MeterRegistry meterRegistry;
    private final Map<String, Counter> itemCounters = new ConcurrentHashMap<>();
    private Counter generalOrdersCounter;

    @PostConstruct
    public void init() {
        this.generalOrdersCounter = Counter.builder("orders.count")
                .description("Total orders count")
                .register(meterRegistry);
    }

    @Override
    @Timed(
            value = "orders.execution.time",
            description = "Time to process getOrder",
            percentiles = {0.5, 0.95}
    )
    public String createOrder(String itemName) {
        generalOrdersCounter.increment();

        Counter itemCounter = itemCounters.computeIfAbsent(itemName, name ->
                Counter.builder("orders.by.item")
                        .description("Orders by specific item")
                        .tag("item", name)
                        .register(meterRegistry)
        );

        itemCounter.increment();

        return "Заказ " + itemName + " успешно создан!";
    }

    public Map<String, Double> getOrdersByItem() {
        Map<String, Double> result = new ConcurrentHashMap<>();
        itemCounters.forEach((item, counter) -> result.put(item, counter.count()));
        return result;
    }
}
