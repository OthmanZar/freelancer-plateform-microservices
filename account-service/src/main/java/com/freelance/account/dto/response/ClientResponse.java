package com.freelance.account.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


@Data

public class ClientResponse extends AccountResponse {


    List<OfferResponse> offers;



}
