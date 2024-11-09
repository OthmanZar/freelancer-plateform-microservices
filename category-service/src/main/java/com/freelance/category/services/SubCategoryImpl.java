package com.freelance.category.services;

import com.freelance.category.dtos.SubCategoryResponse;
import com.freelance.category.entities.Category;
import com.freelance.category.entities.SubCategory;
import com.freelance.category.exceptions.CategoryException;
import com.freelance.category.mappers.SubCategoryMapper;
import com.freelance.category.repositories.CategoryRepository;
import com.freelance.category.repositories.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryImpl implements ISubCategory {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void createSubCategory(SubCategoryRequest categoryRequest) throws CategoryException {
        Category category = categoryRepository.findByCategoryName(categoryRequest.name());

        if(category==null){
            throw new CategoryException("Category Not Found");
        }

        subCategoryRepository.save(SubCategory.
                builder().
                name(categoryRequest.name()).
                category(category).
                build());

    }

    @Override
    public SubCategoryResponse getSubCategoryByName(String name) throws CategoryException {
        SubCategory subCategory = subCategoryRepository.findByName(name);
        if(subCategory==null){
            throw new CategoryException("SubCategory Not Found");
        }

        return subCategoryMapper.toResponse(subCategory);
    }

    @Override
    public SubCategoryResponse getSubCategoryById(Long id) throws CategoryException {
        SubCategory subCategory = subCategoryRepository.
                findById(id).
                orElseThrow(() -> new CategoryException("SubCategory Not Found") );

        return subCategoryMapper.toResponse(subCategory);
    }

    @Override
    public List<String> getAllSubCategoriesByCategory(Long categoryId) throws CategoryException {
        Category category = categoryRepository.
                findById(categoryId).
                orElseThrow(() -> new CategoryException("Category Not Found"));

        List<SubCategory> subCategories = subCategoryRepository.findAllByCategory(category);
        if(subCategories.isEmpty()){
            return List.of();
        }


        return subCategories.
                stream().
                map(SubCategory::getName).toList();
    }

    @Override
    public void deleteSubCategory(Long id) {

    }
}
