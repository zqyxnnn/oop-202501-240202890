package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== Agri-POS System by [Zakkya FAuzan ALba'asithu]-[240202890] ===");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        // Skenario 1: Input Quantity Negatif
        try {
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            System.err.println("Exception Tertangkap: " + e.getMessage());
        }

        // Skenario 2: Hapus Produk yang tidak ada di keranjang
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.err.println("Exception Tertangkap: " + e.getMessage());
        }

                // Skenario 3: Checkout melebihi stok
        try {
            cart.addProduct(p1, 5); 
            cart.checkout();
        } catch (InvalidQuantityException | InsufficientStockException e) { 
            // Menggunakan operator '|' (pipe) untuk menangkap beberapa exception sekaligus
            System.err.println("Exception Tertangkap: " + e.getMessage());
        } finally {
            System.out.println("Program selesai dijalankan.");
        }
    }
}