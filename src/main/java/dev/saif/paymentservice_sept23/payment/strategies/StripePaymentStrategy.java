package dev.saif.paymentservice_sept23.payment.strategies;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import dev.saif.paymentservice_sept23.payment.PaymentStrategy;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class StripePaymentStrategy implements PaymentStrategy {

    @Value("${stripe.key.secret}")
    private String stripeSecretKey;
    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber,
                                      Long amount) {
        try {
            Stripe.apiKey = stripeSecretKey;

            ProductCreateParams productParams =
                    ProductCreateParams.builder()
                            .setName(orderId)
                            .build();
            Product product = Product.create(productParams);

            PriceCreateParams priceParams =
                    PriceCreateParams.builder()
                            .setCurrency("INR")
                            .setUnitAmount(amount)
                            .setProduct(product.getId())
                            .build();
            Price price = Price.create(priceParams);

            PaymentLinkCreateParams linkParams =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            )
                            .build();
            PaymentLink paymentLink = PaymentLink.create(linkParams);

            return paymentLink.getUrl();
        } catch (Exception e) {
            System.out.printf("Exception: %s\n", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
