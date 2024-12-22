package com.freelance.coins.services;

import com.freelance.coins.dtos.CoinsOrderRequest;
import com.freelance.coins.dtos.CoinsRequest;
import com.freelance.coins.dtos.CoinsResponse;
import com.freelance.coins.exceptions.BusinessException;

import java.util.List;

public interface ICoinsService {

    Boolean createPack(CoinsRequest coinsRequest);

    List<CoinsResponse> getAllPacks();

    Long buyPack(CoinsOrderRequest coinsOrderRequest) throws BusinessException;

}
