package com.pavyk96.TestGradle.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private String name;
    private String surname;
    private boolean isParents;
}
