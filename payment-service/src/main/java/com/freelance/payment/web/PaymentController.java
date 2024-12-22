package com.freelance.payment.web;

import com.freelance.payment.dtos.PaymentRequest;
import com.freelance.payment.services.IPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> payOrderFreelancer(@RequestBody @Valid PaymentRequest paymentRequest){

        return ResponseEntity.ok(paymentService.creatPayment(paymentRequest));
    }

}
