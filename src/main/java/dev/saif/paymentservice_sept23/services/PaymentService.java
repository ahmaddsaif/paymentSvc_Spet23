package dev.saif.paymentservice_sept23.services;

import dev.saif.paymentservice_sept23.payment.PaymentGateWayStrategyChooser;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGateWayStrategyChooser paymentGateWayStrategyChooser;

    public PaymentService(PaymentGateWayStrategyChooser paymentGateWayStrategyChooser) {
        this.paymentGateWayStrategyChooser = paymentGateWayStrategyChooser;
    }

    public String initiatePayment(String paymentVendor, String orderId, String email, String phoneNumber,
                                      Long amount) {
        return paymentGateWayStrategyChooser.getPaymentStrategy(paymentVendor)
                .generatePaymentLink(orderId, email, phoneNumber, amount);
    }
}
