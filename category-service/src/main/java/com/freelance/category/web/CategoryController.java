package com.freelance.category.web;

import com.freelance.category.dtos.CategoryRequest;
import com.freelance.category.dtos.CategoryResponse;
import com.freelance.category.exceptions.CategoryException;
import com.freelance.category.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(
            @RequestBody @Valid CategoryRequest categoryRequest
            ){
        categoryService.createCategory(categoryRequest);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<CategoryResponse> findByName(
           @PathVariable String categoryName
    ) throws CategoryException {

        return ResponseEntity.ok( categoryService.getCategoryByName(categoryName));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(
            @PathVariable Long categoryId
    ) throws CategoryException {

        return ResponseEntity.ok( categoryService.getCategoryById(categoryId));
    }

    @GetMapping("/all/noSubs")
    public ResponseEntity<List<String>> findAllWithoutSubs(
    ){

        return ResponseEntity.ok( categoryService.getAllCategoriesWithoutSubs());
    }

    @GetMapping("/all/subs")
    public ResponseEntity<List<CategoryResponse>> findAllWithSubs(
    ){

        return ResponseEntity.ok( categoryService.getAllCategoriesWithSubs());
    }
}
