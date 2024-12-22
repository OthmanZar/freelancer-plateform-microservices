package com.freelance.notification.dtos;

import java.math.BigDecimal;

public record CoinsResponse(

        String packName,
        int nbrOfCoins,
        BigDecimal price
) {
}
