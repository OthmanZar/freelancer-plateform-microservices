package com.freelance.coins.dtos;

import com.freelance.coins.validations.PackNameUnique;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CoinsRequest(

         @NotBlank(message = "Please Provide a Pack Name !!")
         @PackNameUnique
         String packName,

         @Min(value = 10,message = "Minimum coins For a Pack is 10")
         int nbrOfCoins,

         @Positive(message = "The price should positive")
         BigDecimal price

) {
}
