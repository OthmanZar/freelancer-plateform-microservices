package com.freelance.category.dtos;

import com.freelance.category.validations.CategoryUnique;
import com.freelance.category.validations.SubCategoryUnique;
import jakarta.validation.constraints.NotBlank;

public record SubCategoryRequest(
        @NotBlank(message = "Please Provide a SubCategory Name !!")
        @SubCategoryUnique
        String name,
        @NotBlank(message = "Please Provide a Category Name !!")
        String categoryName


) {
}
