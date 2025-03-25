package com.pavyk96.TestGradle.hw4.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Potion {
    private long id;
    private PotionType type;
    private String mantra;
    private int level;
}
