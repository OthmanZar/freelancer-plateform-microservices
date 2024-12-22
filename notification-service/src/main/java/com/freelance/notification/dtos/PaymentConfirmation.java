package com.freelance.notification.dtos;

import com.freelance.notification.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        BigDecimal price,
        PaymentMethod paymentMethod,
        String freelancerFirstName,
        String freelancerLastName,
        String freelancerEmail,
        Long orderId
) {
}
