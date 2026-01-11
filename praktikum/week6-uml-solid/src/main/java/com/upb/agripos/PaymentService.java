package com.upb.agripos;

public class PaymentService {
    private PaymentMethod method;

    // Bergantung pada abstraksi (Interface)
    public PaymentService(PaymentMethod method) {
        this.method = method;
    }

    public void checkout(double total) {
        method.processPayment(total);
    }
}