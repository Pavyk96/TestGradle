package com.pavyk96.TestGradle.hw3.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Template {
    private double price;
    private Info info;
}
