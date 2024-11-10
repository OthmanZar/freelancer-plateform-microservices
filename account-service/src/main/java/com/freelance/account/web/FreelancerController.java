package com.freelance.account.web;

import com.freelance.account.dto.FreelancerResponse;
import com.freelance.account.service.FreelancerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/freelancers")
@AllArgsConstructor
public class FreelancerController {

    FreelancerService service;


    @GetMapping
    public ResponseEntity<List<FreelancerResponse>> findAll(){

        return ResponseEntity.ok(service.findAll());

    }
}
