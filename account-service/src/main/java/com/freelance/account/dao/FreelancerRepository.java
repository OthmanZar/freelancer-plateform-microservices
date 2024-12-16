package com.freelance.account.dao;

import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Freelancer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<Freelancer,String> {



    //specifications for advanced filtering !
    public Page<Freelancer> findAll(Specification<Freelancer> freelancerSpecification,
                                    Pageable pageable);







}
