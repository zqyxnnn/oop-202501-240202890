package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    // Map menyimpan Product sebagai Key dan Integer sebagai jumlahnya (Quantity)
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { 
        // Menambah 1 ke quantity yang sudah ada, atau mulai dari 0 jika baru
        items.put(p, items.getOrDefault(p, 0) + 1); 
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p); // Hapus total jika quantity sisa 1
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            // Harga dikali jumlah barang
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}