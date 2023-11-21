package dev.saif.paymentservice_sept23.controllers;

import dev.saif.paymentservice_sept23.dtos.InitiatePaymentRequestDto;
import dev.saif.paymentservice_sept23.services.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public String generatePaymentLink(@RequestBody InitiatePaymentRequestDto request) {
        return paymentService.initiatePayment("stripe", request.getOrderId(),
                request.getEmail(), request.getPhoneNumber(), request.getAmount());
    }
}
