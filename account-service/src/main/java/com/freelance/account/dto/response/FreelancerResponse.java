package com.freelance.account.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class FreelancerResponse extends AccountResponse{



    String cv;



    List<SubcategoryResponse> subcategories;





}
