package com.freelance.account.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class FreelancerResponse {

    String firstName;


    String lastName;

    String email;


    String cv;

    String imagePath;

    List<SubcategoryResponse> subcategories;





}
