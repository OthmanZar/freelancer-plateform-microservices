package com.freelance.account.dao;

import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Freelancer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {


    AppUser findAppUserByEmail(String email);


    public Page<Freelancer> findAll(Specification<Freelancer> freelancerSpecification,
                                    Pageable pageable);



}
