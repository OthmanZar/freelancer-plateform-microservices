package com.freelance.coins.validations;

import com.freelance.coins.repositories.CoinsRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PackValidator implements ConstraintValidator<PackNameUnique,String> {

    private final CoinsRepository coinsRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return coinsRepository.findByPackName(value) == null;
    }
}
