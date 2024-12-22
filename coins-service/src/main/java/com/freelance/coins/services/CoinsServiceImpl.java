package com.freelance.coins.services;

import com.freelance.coins.clients.FreelancerClient;
import com.freelance.coins.clients.PaymentClient;
import com.freelance.coins.dtos.*;
import com.freelance.coins.entities.Coins;
import com.freelance.coins.entities.Order;
import com.freelance.coins.exceptions.BusinessException;
import com.freelance.coins.kafka.OrderProducer;
import com.freelance.coins.mappers.CoinsMapper;
import com.freelance.coins.repositories.CoinsRepository;
import com.freelance.coins.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoinsServiceImpl implements ICoinsService {

    private static final Logger log = LoggerFactory.getLogger(CoinsServiceImpl.class);
    private final CoinsRepository coinsRepository;
    private final CoinsMapper coinsMapper;
    private final FreelancerClient freelancerClient;
    private final PaymentClient paymentClient;
    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;
    @Override
    public Boolean createPack(CoinsRequest coinsRequest) {

        coinsRepository.save(coinsMapper.toCoins(coinsRequest));

        return true;
    }

    @Override
    public List<CoinsResponse> getAllPacks() {
        List<Coins> coinsList = coinsRepository.findAll();

        return coinsList.stream().map(coinsMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long buyPack(CoinsOrderRequest coinsOrderRequest) throws BusinessException {
        FreelancerResponse freelancerResponse = freelancerClient.
                findFreelancerByID(coinsOrderRequest.freelancerID()).
                orElseThrow(() -> new BusinessException("Cannot create order:: No freelancer exists with the provided ID"));

        Coins pack = coinsRepository.
                findById(coinsOrderRequest.packID()).
                orElseThrow(() -> new BusinessException("Cannot create order:: No Coins Pack exists with the provided ID"));

        Order order = orderRepository.save(Order.builder()
                .packID(pack.getId())
                .freelancerID(coinsOrderRequest.freelancerID())
                .paymentMethod(coinsOrderRequest.paymentMethod())
                .build());


        PaymentRequest paymentRequest = new PaymentRequest(
                pack.getPrice(),
                coinsOrderRequest.paymentMethod(),
                order.getId(),
                freelancerResponse
        );
        //System.out.println(paymentRequest);
        paymentClient.createPayment(paymentRequest);



        orderProducer.sendOrder(new OrderConfirmation(
                order.getId(),
                coinsOrderRequest.paymentMethod(),
                freelancerResponse,
                coinsMapper.toResponse(pack)
        ));

        return order.getId();
    }
}
