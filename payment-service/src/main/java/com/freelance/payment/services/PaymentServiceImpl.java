package com.freelance.payment.services;

import com.freelance.payment.dtos.PaymentNotificationRequest;
import com.freelance.payment.dtos.PaymentRequest;
import com.freelance.payment.entities.Payment;
import com.freelance.payment.kafka.NotificationProducer;
import com.freelance.payment.mappers.PaymentMapper;
import com.freelance.payment.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Long creatPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(paymentRequest.price(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.freelancer().firstName(),
                        paymentRequest.freelancer().lastName(),
                        paymentRequest.freelancer().email(),
                        paymentRequest.orderId())
        );

        return payment.getId();
    }
}
