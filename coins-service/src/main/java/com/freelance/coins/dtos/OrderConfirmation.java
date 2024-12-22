package com.freelance.coins.dtos;

import com.freelance.coins.enums.PaymentMethod;

import java.math.BigDecimal;

public record OrderConfirmation(

        Long orderId,
        PaymentMethod paymentMethod,
        FreelancerResponse freelancerResponse,
        CoinsResponse coinsResponse


) {
}
