package com.freelance.coins.clients;

import com.freelance.coins.dtos.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service",
        url = "http://localhost:5006/api/v1/payment"
)
public interface PaymentClient {

    @PostMapping
    Long createPayment(@RequestBody PaymentRequest paymentRequest);

}
