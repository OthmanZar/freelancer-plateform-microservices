package com.freelance.account.specification;

import com.freelance.account.entities.Freelancer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class FreelancerSpecification {



    //name,idSubcategory

    public  Specification<Freelancer> hasSubCategory(Long subCategoryId) {
        return (root, query, criteriaBuilder) -> {

            return criteriaBuilder.isMember(subCategoryId, root.get("subCategories"));
        };

    }

    public Specification<Freelancer> nameContains(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email"), "%" + keyword + "%");
    }








}
