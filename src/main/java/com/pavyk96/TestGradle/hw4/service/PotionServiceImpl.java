package com.pavyk96.TestGradle.hw4.service;

import com.pavyk96.TestGradle.hw4.dto.PotionRequest;
import com.pavyk96.TestGradle.hw4.dto.PotionResponse;
import com.pavyk96.TestGradle.hw4.model.Potion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PotionServiceImpl implements PotionService {
    private final List<Potion> potionList = new ArrayList<>();

    @Override
    public PotionResponse createPotion(PotionRequest request) {
        Potion potion = Potion.builder()
                .id(potionList.size() + 1L)
                .type(request.getType())
                .mantra(request.getMantra())
                .level(request.getLevel())
                .build();

        potionList.add(potion);
        System.out.println("Зелье сохранено: " + potion);

        return PotionResponse.builder()
                .type(potion.getType())
                .mantra(potion.getMantra())
                .level(potion.getLevel())
                .build();
    }
}
