package com.pavyk96.TestGradle.hw4.dto;

import com.pavyk96.TestGradle.hw4.model.PotionType;
import com.pavyk96.TestGradle.hw4.validators.ValidMantra;
import com.pavyk96.TestGradle.hw4.validators.ValidPotion;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ValidPotion
public class PotionRequest {
    private PotionType type;

    @ValidMantra
    @Size(min = 3, max = 100, message = "Mantra must be 3-100 characters")
    private String mantra;

    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 100, message = "Level cannot exceed 100")
    private int level;
}
