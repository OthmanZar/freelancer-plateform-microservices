package com.freelance.category.services;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.entities.Category;
import com.freelance.category.exceptions.CategoryException;
import com.freelance.category.mappers.CategoryMapper;
import com.freelance.category.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {

        categoryRepository.save(categoryMapper.toCategory(categoryRequest));
    }

    @Override
    public CategoryResponse getCategoryByName(String name) throws CategoryException {
        Category category = categoryRepository.findByCategoryName(name);

        if(category==null){
            throw new CategoryException("Category Name not Found");
        }

        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) throws CategoryException {
        Category category = categoryRepository.findById(id).
                orElseThrow(() ->  new CategoryException("Category not Found"));

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<String> getAllCategoriesWithoutSubs() {
        List<Category> categories;
        categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            return List.of();
        }

        return categories.
                stream().
                map(Category::getCategoryName).
                toList();
    }

    @Override
    public List<CategoryResponse> getAllCategoriesWithSubs() {
        List<Category> categories;
        categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            return List.of();
        }

        return categories.
                stream().
                map(category -> categoryMapper.toResponse(category)).
                toList();
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
