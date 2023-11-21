package dev.saif.paymentservice_sept23.payment;

import dev.saif.paymentservice_sept23.payment.strategies.StripePaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentGateWayStrategyChooser {
    private final StripePaymentStrategy stripePaymentStrategy;

    public PaymentGateWayStrategyChooser(StripePaymentStrategy stripePaymentStrategy) {
        this.stripePaymentStrategy = stripePaymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy(String paymentVendor) {
        if (paymentVendor.equals("stripe")) {
            return stripePaymentStrategy;
        }
        return null;
    }
}
