package com.freelance.offers.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class OfferRequest {
    String clientId;

    String title;

    String description;



    LocalDate endDate;

    double price;

    List<Long> subCategories;



}
