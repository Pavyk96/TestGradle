package com.pavyk96.TestGradle.controller;

import com.pavyk96.TestGradle.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MetricsController {

    private final ItemServiceImpl itemService;

    @GetMapping("/api/metrics/orders-by-item")
    public ResponseEntity<Map<String, Double>> getOrdersByItem() {
        Map<String, Double> metrics = itemService.getOrdersByItem();
        return ResponseEntity.ok(metrics);
    }
}
