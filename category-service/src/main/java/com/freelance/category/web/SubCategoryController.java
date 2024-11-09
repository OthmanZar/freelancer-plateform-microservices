package com.freelance.category.web;


import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.dtos.SubCategoryRequest;
import com.freelance.category.dtos.SubCategoryResponse;
import com.freelance.category.exceptions.CategoryException;
import com.freelance.category.services.ISubCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sub-categories")
public class SubCategoryController {

    private final ISubCategoryService subCategory;


    @PostMapping
    public ResponseEntity<?> createSubCategory(
            @RequestBody @Valid SubCategoryRequest subCategoryRequest
    ) throws CategoryException {
        subCategory.createSubCategory(subCategoryRequest);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/name/{subCategoryName}")
    public ResponseEntity<SubCategoryResponse> findByName(
            @PathVariable String subCategoryName
    ) throws CategoryException {

        return ResponseEntity.ok( subCategory.getSubCategoryByName(subCategoryName));
    }

    @GetMapping("/id/{subCategoryId}")
    public ResponseEntity<SubCategoryResponse> findById(
            @PathVariable Long subCategoryId
    ) throws CategoryException {

        return ResponseEntity.ok( subCategory.getSubCategoryById(subCategoryId));
    }


    @GetMapping("/all/{categoryID}")
    public ResponseEntity<List<String>> findAllWithCategory(
            @PathVariable Long categoryID
    ) throws CategoryException {

        return ResponseEntity.ok( subCategory.getAllSubCategoriesByCategory(categoryID));
    }

}
