package com.freelance.payment.dtos;

import com.freelance.payment.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(

        BigDecimal price,
        PaymentMethod paymentMethod,
        String freelancerFirstName,
        String freelancerLastName,
        String freelancerEmail,
        Long orderId


) {
}
