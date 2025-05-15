package com.pavyk96.TestGradle.controller;

import com.pavyk96.TestGradle.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @PostMapping("/api/orders/{itemId}")
    public ResponseEntity<String> createOrder(@PathVariable String itemId) {
        String result = service.createOrder(itemId);
        return ResponseEntity.ok(result);
    }
}
