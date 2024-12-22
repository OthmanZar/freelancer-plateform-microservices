package com.freelance.notification.dtos;

import com.freelance.notification.enums.PaymentMethod;

public record OrderConfirmation(
        Long orderId,
        PaymentMethod paymentMethod,
        FreelancerResponse freelancerResponse,
        CoinsResponse coinsResponse

) {
}
