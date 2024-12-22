package com.freelance.coins.clients;

import com.freelance.coins.dtos.FreelancerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "account-service",
        url = "http://localhost:5005/api/v1/freelancers"
)
public interface FreelancerClient {

    @GetMapping("/{id}")
    Optional<FreelancerResponse> findFreelancerByID(@PathVariable("id") String freelancerID);

}
