package com.freelance.offers.mappers;

import com.freelance.offers.client.AccountClient;
import com.freelance.offers.client.SubCategoryClient;
import com.freelance.offers.dto.ClientResponse;
import com.freelance.offers.dto.OfferRequest;
import com.freelance.offers.dto.OfferResponse;
import com.freelance.offers.dto.SubcategoryResponse;
import com.freelance.offers.entities.Offer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OfferMapper {


  AccountClient clientService;
  SubCategoryClient subCategoryClient;
    public Offer mapToEntity(OfferRequest request) {
        if (request == null) {
            return null;
        }

        Offer offer = new Offer();
        offer.setClientId(request.getClientId());
        offer.setTitle(request.getTitle());
        offer.setDescription(request.getDescription());
        offer.setCreatedAt(LocalDate.now());
        offer.setEndDate(request.getEndDate());
        offer.setPrice(request.getPrice());


        if (request.getSubCategories() != null) {
            offer.setSubCategories(request.getSubCategories());
        } else {
            offer.setSubCategories(new ArrayList<>());
        }

        return offer;
    }

    public OfferResponse mapToResponse(Offer offer) {
        if (offer == null) {
            return null;
        }

        OfferResponse response = new OfferResponse();
       //call client service

        ClientResponse clientResponse=clientService.findClientById(offer.getClientId())
                .orElseThrow(()->new RuntimeException("Error while fetching client with id : "+offer.getClientId()));

        response.setClient(clientResponse);

        response.setTitle(offer.getTitle());
        response.setDescription(offer.getDescription());
        response.setCreatedAt(offer.getCreatedAt());
        response.setEndDate(offer.getEndDate());
        response.setPrice(offer.getPrice());


        if (offer.getSubCategories() != null) {

            List<SubcategoryResponse> subcategoryResponses = offer.getSubCategories()

                    .stream().map(subCategoryClient::findSubCategoriesById)
                    .collect(Collectors.toList());

            response.setSubcategories(subcategoryResponses);

        } else {
            response.setSubcategories(new ArrayList<>());
        }

        return response;
    }

}
