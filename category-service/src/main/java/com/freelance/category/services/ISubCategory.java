package com.freelance.category.services;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.dtos.SubCategoryResponse;
import com.freelance.category.exceptions.CategoryException;

import java.util.List;

public interface ISubCategory {


    void createSubCategory(SubCategoryRequest categoryRequest) throws CategoryException;


    SubCategoryResponse getSubCategoryByName(String name) throws CategoryException;

    SubCategoryResponse getSubCategoryById(Long id) throws CategoryException;

    List<String> getAllSubCategoriesByCategory(Long categoryId) throws CategoryException;


    void deleteSubCategory(Long id);

}
