package com.pavyk96.TestGradle.hw4.service;

import com.pavyk96.TestGradle.hw4.dto.PotionRequest;
import com.pavyk96.TestGradle.hw4.dto.PotionResponse;

public interface PotionService {
    PotionResponse createPotion(PotionRequest request);
}
