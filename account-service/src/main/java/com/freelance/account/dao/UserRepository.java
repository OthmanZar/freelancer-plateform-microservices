package com.freelance.account.dao;

import com.freelance.account.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {


    AppUser findAppUserByEmail(String email);




}
