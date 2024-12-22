package com.freelance.notification.kafka;

import com.freelance.notification.dtos.OrderConfirmation;
import com.freelance.notification.dtos.PaymentConfirmation;
import com.freelance.notification.entities.Notification;
import com.freelance.notification.enums.NotificationType;
import com.freelance.notification.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(PaymentConfirmation paymentConfirmation){
        log.info(String.format("Message from topic payment-ms : %s",paymentConfirmation));
        notificationRepository.save(Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                .build());


    }


    @KafkaListener(topics = "order-topic")
    public void consumeOrderNotification(OrderConfirmation orderConfirmation){
        log.info(String.format("Message from topic order-ms : %s",orderConfirmation));
        notificationRepository.save(Notification.builder()
                .type(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build());


    }
}
