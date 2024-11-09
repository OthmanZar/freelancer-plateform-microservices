package com.freelance.category.dtos;

import com.freelance.category.entities.SubCategory;

import java.util.List;

public record CategoryResponse(
        Long id,
        String categoryName,
        List<SubCategoryResponse> subCategories

) {
}
