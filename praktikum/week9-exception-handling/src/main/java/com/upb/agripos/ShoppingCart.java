package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Gagal: Quantity (" + qty + ") harus lebih dari 0.");
        }
        items.put(p, items.getOrDefault(p, 0) + qty);
        System.out.println("Berhasil menambah: " + p.getName() + " sebanyak " + qty);
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new ProductNotFoundException("Gagal: Produk " + p.getName() + " tidak ditemukan di keranjang.");
        }
        items.remove(p);
        System.out.println("Berhasil menghapus: " + p.getName());
    }

    public void checkout() throws InsufficientStockException {
        System.out.println("--- Memulai Proses Checkout ---");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            
            if (product.getStock() < qty) {
                throw new InsufficientStockException(
                    "Gagal Checkout: Stok " + product.getName() + " kurang (Tersedia: " + 
                    product.getStock() + ", Diminta: " + qty + ")"
                );
            }
        }
        
        // Jika semua stok cukup, kurangi stok produk
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        System.out.println("Checkout Berhasil! Stok telah diperbarui.");
    }
}