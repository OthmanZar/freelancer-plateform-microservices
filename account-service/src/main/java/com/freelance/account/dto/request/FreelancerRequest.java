package com.freelance.account.dto.request;

import com.freelance.account.enums.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class FreelancerRequest extends AbstractRequest {


    @NotNull(message = "yous should provide ids of subcategories")
    List<Long> subCategories; //id of subcategories  [1,2,3,4]

    SkillRequest skillRequest;

    @NotNull(message = "birthday is mandatory")

    LocalDate birthDay;


    @NotNull(message = "sex is mandatory")

    Sex sex;


    public List<Long> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Long> subCategories) {
        this.subCategories = subCategories;
    }

}
