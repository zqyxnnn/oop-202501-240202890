package com.upb.agripos;

public class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pembayaran Tunai Berhasil: Rp" + amount);
    }
}