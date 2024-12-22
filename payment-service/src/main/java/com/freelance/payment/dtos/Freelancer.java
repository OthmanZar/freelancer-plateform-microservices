package com.freelance.payment.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Freelancer(

        @NotNull(message = "Firstname is required")
        String firstName,
        @NotNull(message = "LastName is required")
        String lastName,
        @NotNull(message = "Email is required")
                @Email(message = "Email Not formatted")
        String email

) {
}
