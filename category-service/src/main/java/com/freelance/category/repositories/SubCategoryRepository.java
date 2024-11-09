package com.freelance.category.repositories;

import com.freelance.category.entities.Category;
import com.freelance.category.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    SubCategory findByName(String name);
    List<SubCategory> findAllByCategory(Category category);
}
