package com.freelance.account.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "offerClient", url = "http://localhost:5005")
public interface OffersClient {



}
