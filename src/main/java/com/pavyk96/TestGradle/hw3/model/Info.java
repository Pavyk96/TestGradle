package com.pavyk96.TestGradle.hw3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Info {
    private int id;
    private String date;
}
