package com.freelance.account.service;

import com.freelance.account.dto.FreelancerRequest;
import com.freelance.account.dto.FreelancerResponse;

import java.util.List;

public interface FreelancerService {
    public List<FreelancerResponse> findAll();

}
