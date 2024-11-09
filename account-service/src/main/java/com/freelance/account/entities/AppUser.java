package com.freelance.account.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    String id;

    String firstName;
    String lastName;




}
