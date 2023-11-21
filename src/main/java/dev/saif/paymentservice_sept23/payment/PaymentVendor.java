package dev.saif.paymentservice_sept23.payment;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public abstract class PaymentVendor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String generatePaymentLink(String orderId, String email, String phoneNumber,
                                      Long amount) {
        return paymentStrategy.generatePaymentLink(orderId, email, phoneNumber, amount);
    }

}
