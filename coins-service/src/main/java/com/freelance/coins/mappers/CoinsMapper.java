package com.freelance.coins.mappers;

import com.freelance.coins.dtos.CoinsRequest;
import com.freelance.coins.dtos.CoinsResponse;
import com.freelance.coins.entities.Coins;
import org.springframework.stereotype.Service;

@Service
public class CoinsMapper {

    public Coins toCoins(CoinsRequest coinsRequest){
        Coins coins = new Coins();
        coins.setNbrOfCoins(coinsRequest.nbrOfCoins());
        coins.setPrice(coinsRequest.price());
        coins.setPackName(coinsRequest.packName());

        return coins;
    }

    public CoinsResponse toResponse(Coins coins){

        return new CoinsResponse(
                coins.getPackName(),
                coins.getNbrOfCoins(),
                coins.getPrice());
    }
}
