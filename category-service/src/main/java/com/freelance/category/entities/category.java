package com.freelance.category.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class category {

    @Id
    Long id;

    String categoryName;

}
