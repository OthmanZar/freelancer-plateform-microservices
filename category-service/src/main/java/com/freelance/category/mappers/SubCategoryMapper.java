package com.freelance.category.mappers;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.SubCategoryResponse;
import com.freelance.category.entities.Category;
import com.freelance.category.entities.SubCategory;
import com.freelance.category.services.SubCategoryRequest;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryMapper {

    public SubCategory toSubCategory(SubCategoryRequest subcategoryRequest){

        return SubCategory.builder().
                name(subcategoryRequest.name())
                .build();
    }
    public SubCategoryResponse toResponse(SubCategory subcategory){

        return new SubCategoryResponse(
                subcategory.getId(),
                subcategory.getName()
        );
    }
}
