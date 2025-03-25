package com.pavyk96.TestGradle.hw4.validators;

import com.pavyk96.TestGradle.hw4.dto.PotionRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PotionValidator implements ConstraintValidator<ValidPotion, PotionRequest> {
    @Override
    public void initialize(ValidPotion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PotionRequest request, ConstraintValidatorContext context) {
        if (request.getType() == null) {
            context.buildConstraintViolationWithTemplate("Potion type is required")
                    .addPropertyNode("type")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
