package com.freelance.account.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class FreelancerRequest extends AbstractRequest {


    @NotNull(message = "yous should provide ids of subcategories")
    List<Long> subCategories; //id of subcategories  [1,2,3,4]

    SkillRequest skillRequest;



    public List<Long> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Long> subCategories) {
        this.subCategories = subCategories;
    }
}
