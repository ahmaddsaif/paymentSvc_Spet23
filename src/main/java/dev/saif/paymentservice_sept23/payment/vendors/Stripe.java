package dev.saif.paymentservice_sept23.payment.vendors;

import dev.saif.paymentservice_sept23.payment.PaymentStrategy;
import dev.saif.paymentservice_sept23.payment.PaymentVendor;
import dev.saif.paymentservice_sept23.payment.strategies.StripePaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class Stripe extends PaymentVendor {
    PaymentStrategy paymentStrategy;
    public Stripe() {
        paymentStrategy = new StripePaymentStrategy();
    }
}
