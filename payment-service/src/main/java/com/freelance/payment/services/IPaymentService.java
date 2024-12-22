package com.freelance.payment.services;


import com.freelance.payment.dtos.PaymentRequest;

public interface IPaymentService {

    Long creatPayment(PaymentRequest paymentRequest);
}
