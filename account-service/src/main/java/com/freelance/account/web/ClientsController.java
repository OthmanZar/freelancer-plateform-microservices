package com.freelance.account.web;


import com.freelance.account.dto.response.ClientResponse;
import com.freelance.account.dto.response.OfferResponse;
import com.freelance.account.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor
public class ClientsController {

    ClientService clientService;


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findClient(@PathVariable("id")String id){

        return ResponseEntity.ok(clientService.findClientById(id));

    }










}


