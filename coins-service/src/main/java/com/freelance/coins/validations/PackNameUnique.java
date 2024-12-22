package com.freelance.coins.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PackValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PackNameUnique {
    String message() default "Pack Name is already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
