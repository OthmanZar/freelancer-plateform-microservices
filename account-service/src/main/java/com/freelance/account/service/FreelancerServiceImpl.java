package com.freelance.account.service;

import com.freelance.account.client.SubCategoryClient;
import com.freelance.account.dao.FreelancerRepository;
import com.freelance.account.dao.UserRepository;
import com.freelance.account.dto.FreelancerRequest;
import com.freelance.account.dto.FreelancerResponse;
import com.freelance.account.dto.SubcategoryResponse;
import com.freelance.account.mappers.AccountsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class FreelancerServiceImpl implements FreelancerService{

FreelancerRepository repository;



SubCategoryClient client;

AccountsMapper mapper;
    @Override
    public List<FreelancerResponse> findAll() {

        return repository.findAll().stream().map(freelancer -> {

           FreelancerResponse freelancerResponse= mapper.fromEntity(freelancer);

           List<SubcategoryResponse > subcategoryResponses=freelancer.getSubCategories()

                   .stream().map(client::findSubCategoriesById)
                   .collect(Collectors.toList());

           freelancerResponse.setSubcategories(subcategoryResponses);


         return freelancerResponse;

        }).collect(Collectors.toList());





    }
}
