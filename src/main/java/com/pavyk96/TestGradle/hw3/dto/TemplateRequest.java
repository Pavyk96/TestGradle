package com.pavyk96.TestGradle.hw3.dto;

import com.pavyk96.TestGradle.hw3.model.Info;
import lombok.Data;
import lombok.NonNull;

@Data
public class TemplateRequest {
    private double price;
    private Info info;
}
