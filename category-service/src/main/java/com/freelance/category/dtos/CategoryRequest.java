package com.freelance.category.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Please Provide a Category Name !!")
        String categoryName

) {
}
