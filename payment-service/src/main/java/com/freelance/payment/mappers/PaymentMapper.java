package com.freelance.payment.mappers;

import com.freelance.payment.dtos.PaymentRequest;
import com.freelance.payment.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public   Payment toPayment(PaymentRequest paymentRequest){
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentRequest.paymentMethod());
        payment.setPrice(paymentRequest.price());
        payment.setOrderId(paymentRequest.orderId());

        return payment;

    }
}
