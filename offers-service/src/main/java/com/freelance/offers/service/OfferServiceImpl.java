package com.freelance.offers.service;

import com.freelance.offers.client.AccountClient;
import com.freelance.offers.dao.OfferRepository;
import com.freelance.offers.dto.ClientResponse;
import com.freelance.offers.dto.OfferRequest;
import com.freelance.offers.dto.OfferResponse;
import com.freelance.offers.entities.Offer;
import com.freelance.offers.mappers.OfferMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {

    OfferRepository offerRepository;

    OfferMapper offerMapper;

    AccountClient clientService;
    @Override
    @Transactional
    public OfferResponse createOffer(OfferRequest offerRequest) {


        ClientResponse clientResponse=clientService.findClientById(offerRequest.getClientId())
                .orElseThrow(()->new RuntimeException("An error while fetching client with id : "+offerRequest.getClientId()));


        //at this point no problem no error
        Offer offer=offerMapper.mapToEntity(offerRequest);



        return offerMapper.mapToResponse(offer);

    }
}
