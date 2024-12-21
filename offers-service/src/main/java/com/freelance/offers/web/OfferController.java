package com.freelance.offers.web;


import com.freelance.offers.dto.OfferRequest;
import com.freelance.offers.dto.OfferResponse;
import com.freelance.offers.service.OfferService;
import feign.Response;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/offers")


public class OfferController {

    OfferService offerService;

    @PostMapping
    public ResponseEntity<OfferResponse> create(@Valid @RequestBody OfferRequest request){


        return ResponseEntity.ok(offerService.createOffer(request));

    }


}
