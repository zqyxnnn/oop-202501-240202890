package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // Ganti [Nama] dan [NIM] dengan identitas asli Anda
        System.out.println("Hello, I am [Zakkya Fauzan Alba'asithu]-[240202890] (Week7)");

        // Membuat objek produk
        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        // --- MENGUJI BAGIAN 2 (ARRAYLIST) ---
        System.out.println("\n=== Testing ArrayList Version ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        System.out.println("Setelah Beras dihapus:");
        cart.printCart();

        // --- MENGUJI BAGIAN 4 (MAP DENGAN QUANTITY) ---
        System.out.println("\n=== Testing Map Version (Quantity) ===");
        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.addProduct(p1);
        cartMap.addProduct(p1); // Menambah Beras 2x agar terlihat quantity-nya
        cartMap.addProduct(p2);
        cartMap.printCart();
    }
}