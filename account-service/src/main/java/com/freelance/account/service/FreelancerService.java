package com.freelance.account.service;

import com.freelance.account.dto.response.FreelancerResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreelancerService {
    public List<FreelancerResponse> findAll();

    public List<FreelancerResponse> filterByNameAndSubcategory(String name, Long subcategory, Pageable pageable);


    FreelancerResponse findById(String id);



}
