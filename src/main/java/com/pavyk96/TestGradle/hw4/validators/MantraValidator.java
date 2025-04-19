package com.pavyk96.TestGradle.hw4.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class MantraValidator implements ConstraintValidator<ValidMantra, String> {
    private static final Pattern MANTRA_PATTERN =
            Pattern.compile("^[\\p{IsGreek}@_+-]+$");

    @Override
    public void initialize(ValidMantra constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String mantra, ConstraintValidatorContext context) {
        if (mantra == null) return false;
        return MANTRA_PATTERN.matcher(mantra).matches();
    }
}
