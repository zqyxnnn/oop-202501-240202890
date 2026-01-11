package com.upb.agripos;

public class MainApp {
    public static void main(String[] args) {
        // Contoh pembayaran menggunakan Cash (Bisa diganti EWallet tanpa ubah Service)
        PaymentMethod myMethod = new CashPayment(); 
        PaymentService service = new PaymentService(myMethod);
        
        System.out.println("=== Agri-POS Transaction ===");
        service.checkout(50000.0);
    }
}