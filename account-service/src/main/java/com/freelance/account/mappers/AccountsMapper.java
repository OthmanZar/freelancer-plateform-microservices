package com.freelance.account.mappers;

import com.freelance.account.client.SubCategoryClient;
import com.freelance.account.dto.request.ClientRequest;
import com.freelance.account.dto.request.FreelancerRequest;
import com.freelance.account.dto.response.AccountResponse;
import com.freelance.account.dto.response.ClientResponse;
import com.freelance.account.dto.response.FreelancerResponse;
import com.freelance.account.dto.response.SubcategoryResponse;
import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Client;
import com.freelance.account.entities.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class AccountsMapper {

    PasswordEncoder encoder;

    SubCategoryClient client;

    public Freelancer fromRequest(FreelancerRequest request) {

        Freelancer freelancer = new Freelancer();
        freelancer.setFirstName(request.getFirstName());
        freelancer.setLastName(request.getLastName());
        freelancer.setEmail(request.getEmail());

        freelancer.setBirthDay(request.getBirthDay());
        freelancer.setSubCategories(request.getSubCategories());
        freelancer.setSex(request.getSex());

        freelancer.setPassword(encoder.encode(request.getPassword()));


        freelancer.setEnabled(false);

        return freelancer;


    }


    public FreelancerResponse fromEntity(Freelancer entity) {

        FreelancerResponse resp = new FreelancerResponse();

        resp.setEmail(entity.getEmail());
        resp.setLastName(entity.getLastName());

        resp.setFirstName(entity.getFirstName());

        resp.setImagePath(entity.getImage());
        resp.setCv(entity.getCv());
        List<SubcategoryResponse> subcategoryResponses = entity.getSubCategories()

                .stream().map(client::findSubCategoriesById)
                .collect(Collectors.toList());

        resp.setSubcategories(subcategoryResponses);

        return resp;


    }

    public ClientResponse fromClientEntity(Client entity) {

        ClientResponse resp = new ClientResponse();

        resp.setEmail(entity.getEmail());
        resp.setLastName(entity.getLastName());

        resp.setFirstName(entity.getFirstName());

        resp.setImagePath(entity.getImage());

        // fetch list of offers

        return resp;


    }


    public Client fromClientRequest(ClientRequest request) {

        Client client = new Client();
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());

        client.setBirthDay(request.getBirthDay());

        client.setSex(request.getSex());

        client.setPassword(encoder.encode(request.getPassword()));


        client.setEnabled(false);

        return client;


    }




}
