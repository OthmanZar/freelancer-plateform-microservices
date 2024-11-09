package com.freelance.category.services;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.exceptions.CategoryException;

import java.util.List;

public interface ICategoryService {

    void createCategory(CategoryRequest categoryRequest);

    CategoryResponse getCategoryByName(String name) throws CategoryException;

    CategoryResponse getCategoryById(Long id) throws CategoryException;

    List<String> getAllCategoriesWithoutSubs();

    List<CategoryResponse> getAllCategoriesWithSubs();

    void deleteCategory(Long id);

}
