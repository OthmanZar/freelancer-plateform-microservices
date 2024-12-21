package com.freelance.account.entities;

import com.freelance.account.enums.Authorities;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;


@Entity
public class Client extends AppUser{


    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(

                (GrantedAuthority)()-> Authorities.CLIENT.toString()

        );
    }




}
