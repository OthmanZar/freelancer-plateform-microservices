package com.freelance.category.validations;

import com.freelance.category.repositories.SubCategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubCategoryValidator implements ConstraintValidator<SubCategoryUnique,String> {

    private final SubCategoryRepository subCategoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return subCategoryRepository.findByName(value) == null;
    }
}
