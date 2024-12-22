package com.freelance.payment.dtos;

import com.freelance.payment.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal price,

        PaymentMethod paymentMethod,

        Long orderId,

        Freelancer freelancer


) {
}
