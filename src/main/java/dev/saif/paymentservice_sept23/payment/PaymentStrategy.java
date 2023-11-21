package dev.saif.paymentservice_sept23.payment;

import org.springframework.stereotype.Service;

@Service
public interface PaymentStrategy {
    String generatePaymentLink(String orderId, String email, String phoneNumber,
                                      Long amount);
}
