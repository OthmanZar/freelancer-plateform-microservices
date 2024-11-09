package com.freelance.account.mappers;

import com.freelance.account.dto.FreelancerRequest;
import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class AccountsMapper {

PasswordEncoder encoder;

    public Freelancer fromRequest(FreelancerRequest request){

        Freelancer freelancer=new Freelancer();

        freelancer.setEmail(request.getEmail());

        freelancer.setBirthDay(request.getBirthDay());
        freelancer.setSubCategories(request.getSubCategories());
        freelancer.setSex(request.getSex());

        freelancer.setPassword(encoder.encode(request.getPassword()));

        freelancer.setEnabled(false);

        return freelancer;




    }
}
