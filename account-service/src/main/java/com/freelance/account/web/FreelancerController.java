package com.freelance.account.web;

import com.freelance.account.dto.response.FreelancerResponse;
import com.freelance.account.service.FreelancerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/freelancers")
@AllArgsConstructor
public class FreelancerController {

    FreelancerService service;


//    @GetMapping
//    public ResponseEntity<List<FreelancerResponse>> findAll(){
//
//        return ResponseEntity.ok(service.findAll());
//
//    }

    @GetMapping
    List<FreelancerResponse> freelancers(@RequestParam(value = "name", defaultValue = "") String name,
                          @RequestParam(value = "subcategory", defaultValue = "0") Long subcategory,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "items", defaultValue = "4") int items) {


        return service.filterByNameAndSubcategory(name,subcategory,PageRequest.of(page,items)) ;





    }
    @GetMapping("/{id}")
    ResponseEntity<FreelancerResponse> findFreelancer(@PathVariable("id")String id) {


        return  ResponseEntity.ok(service.findById(id)) ;





    }


}
