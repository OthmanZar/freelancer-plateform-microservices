package com.freelance.coins.dtos;

import com.freelance.coins.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal price,

        PaymentMethod paymentMethod,

        Long orderId,

        FreelancerResponse freelancer
) {
}
