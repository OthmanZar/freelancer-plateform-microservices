package com.freelance.account.service;

import com.freelance.account.client.SubCategoryClient;
import com.freelance.account.dao.FreelancerRepository;
import com.freelance.account.dto.response.FreelancerResponse;
import com.freelance.account.entities.Freelancer;
import com.freelance.account.exception.UserNotFoundException;
import com.freelance.account.mappers.AccountsMapper;
import com.freelance.account.specification.FreelancerSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    FreelancerRepository repository;

    FreelancerSpecification specifications;


    SubCategoryClient client;

    AccountsMapper mapper;

    @Override
    public List<FreelancerResponse> findAll() {

        return repository.findAll().stream()
                .map(mapper::fromEntity).collect(Collectors.toList());


    }

    @Override
    public List<FreelancerResponse> filterByNameAndSubcategory(String name, Long subcategory, Pageable pageable) {


        Specification<Freelancer> spec = Specification.where(null);
        spec = spec.and(specifications.nameContains(name));

        if (subcategory > 0)
            spec = spec.and(specifications.hasSubCategory(subcategory));

        Page<Freelancer> freelancerPage = repository.findAll(spec, pageable);

        return freelancerPage.getContent()

                .stream().map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FreelancerResponse findById(String id) {

        return repository.findById(id)
                .map(mapper::fromEntity)
                .orElseThrow(() -> new UserNotFoundException("Cannot find a user with id " + id));


    }


}
