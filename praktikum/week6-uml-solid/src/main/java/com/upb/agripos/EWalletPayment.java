package com.upb.agripos;

public class EWalletPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pembayaran E-Wallet Berhasil: Rp" + amount);
        System.out.println("Status: Saldo terpotong via Payment Gateway.");
    }
}