package com.freelance.account.entities;

import com.freelance.account.enums.Authorities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Builder

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer extends AppUser {

    String cv;


    @ElementCollection
    @CollectionTable(name = "freelancer_subcategories", joinColumns = @JoinColumn(name = "subcategory_id"))

    private List<Long> subCategories;





    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }



    public List<Long> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Long> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(

                (GrantedAuthority)()->Authorities.FREELANCER.toString()

        );

    }
}
