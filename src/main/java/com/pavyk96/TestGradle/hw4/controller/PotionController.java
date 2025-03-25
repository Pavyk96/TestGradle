package com.pavyk96.TestGradle.hw4.controller;

import com.pavyk96.TestGradle.hw4.dto.PotionRequest;
import com.pavyk96.TestGradle.hw4.dto.PotionResponse;
import com.pavyk96.TestGradle.hw4.service.PotionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class PotionController {
    private final PotionService service;

    @PostMapping("/potion")
    public ResponseEntity<?> createPotion(@Valid @RequestBody PotionRequest request) {
        PotionResponse response = service.createPotion(request);
        return ResponseEntity.ok(response);
    }
}
