package com.freelance.category.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy =  SubCategoryValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SubCategoryUnique {
    String message() default "SubCategory is already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
