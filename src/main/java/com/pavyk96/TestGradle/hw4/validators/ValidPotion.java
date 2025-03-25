package com.pavyk96.TestGradle.hw4.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@NotNull(message = "Potion cannot be null")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PotionValidator.class)
public @interface ValidPotion {
    String message() default "Invalid potion data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}