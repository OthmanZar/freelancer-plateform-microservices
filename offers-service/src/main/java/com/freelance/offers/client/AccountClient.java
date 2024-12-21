package com.freelance.offers.client;


import com.freelance.offers.dto.ClientResponse;
import com.freelance.offers.dto.SubcategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "client-service",url = "http://localhost:5005/api/v1/clients")
public interface AccountClient {


    @GetMapping("/{id}")
    Optional<ClientResponse> findClientById(@PathVariable("id") String id);



}
