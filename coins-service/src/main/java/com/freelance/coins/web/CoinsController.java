package com.freelance.coins.web;

import com.freelance.coins.dtos.CoinsOrderRequest;
import com.freelance.coins.dtos.CoinsRequest;
import com.freelance.coins.dtos.CoinsResponse;
import com.freelance.coins.exceptions.BusinessException;
import com.freelance.coins.services.ICoinsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coins")
@RequiredArgsConstructor
public class CoinsController {

    private final ICoinsService coinsService;

    @PostMapping
    public ResponseEntity<Boolean> createCoinsPack(@RequestBody @Valid CoinsRequest coinsRequest){

        return  ResponseEntity.ok(coinsService.createPack(coinsRequest));
    }

    @PostMapping("/order")
    public ResponseEntity<Long> buyPack(@RequestBody @Valid CoinsOrderRequest coinsOrderRequest) throws BusinessException {

        return ResponseEntity.ok(coinsService.buyPack(coinsOrderRequest));
    }

    @GetMapping
    public ResponseEntity<List<CoinsResponse>> findAllPacks(){

        return ResponseEntity.ok(coinsService.getAllPacks());
    }
}
