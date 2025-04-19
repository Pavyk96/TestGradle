package com.pavyk96.TestGradle.hw4.dto;

import com.pavyk96.TestGradle.hw4.model.PotionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PotionResponse {
    private PotionType type;
    private String mantra;
    private int level;
}
