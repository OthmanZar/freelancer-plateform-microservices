package com.freelance.coins.kafka;

import com.freelance.coins.dtos.OrderConfirmation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderProducer {
    private  KafkaTemplate<String,OrderConfirmation> kafkaTemplate;

    public void sendOrder(OrderConfirmation orderConfirmation){
        log.info("Sending order <{}>",orderConfirmation);

        Message<OrderConfirmation> message = MessageBuilder
                .withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();

        kafkaTemplate.send(message);
    }
}
