package com.freelance.account.client;


import com.freelance.account.dto.SubcategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subcategory-service",url = "http://localhost:5002/api/v1/sub-categories")

public interface SubCategoryClient {


    @GetMapping("/id/{id}")
    SubcategoryResponse findSubCategoriesById(@PathVariable("id") Long id);







}
