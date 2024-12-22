package com.freelance.coins.dtos;

import com.freelance.coins.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CoinsOrderRequest(
        @NotNull(message = "Freelancer should be present")
        @NotEmpty(message = "Freelancer should be present")
        @NotBlank(message = "Freelancer should be present")
        String freelancerID,

        @NotNull(message = "Pack should be present")
        Long packID,

        @NotNull(message = "Payment method should be precised")
        PaymentMethod paymentMethod
) {
}
