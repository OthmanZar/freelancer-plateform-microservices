package com.freelance.offers.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Offer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String clientId;

    String title;

    String description;

    LocalDate createdAt;

    LocalDate endDate;

    double price;

    @ElementCollection
    @CollectionTable(name = "offer_subcategories", joinColumns = @JoinColumn(name = "subcategory_id"))

    private List<Long> subCategories;






}
