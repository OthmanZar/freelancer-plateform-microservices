package com.freelance.offers.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OfferResponse {


    Long id;
    ClientResponse client;

    String title;

    String description;

    LocalDate createdAt;

    LocalDate endDate;

    double price;

    List<SubcategoryResponse> subcategories;



}
