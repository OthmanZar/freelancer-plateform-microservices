package com.freelance.category.mappers;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryMapper {

    private final SubCategoryMapper subCategoryMapper;

    public Category toCategory(CategoryRequest categoryRequest){

        return Category.builder().
                categoryName(categoryRequest.categoryName())
                .build();
    }

    public CategoryResponse toResponse(Category category){

        return new CategoryResponse(
                category.getId(),
                category.getCategoryName(),
                category.getSubCategoryList().
                        stream().
                        map(subCategoryMapper::toResponse).
                        collect(Collectors.toList())
        );
    }
}
