package com.pavyk96.TestGradle.hw4.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MantraValidator.class)
public @interface ValidMantra {
    String message() default "Mantra must contain only @_+- and Greek letters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
