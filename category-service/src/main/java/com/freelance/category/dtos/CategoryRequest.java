package com.freelance.category.dtos;

import com.freelance.category.validations.CategoryUnique;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Please Provide a Category Name !!")
        @CategoryUnique
        String categoryName

) {
}
