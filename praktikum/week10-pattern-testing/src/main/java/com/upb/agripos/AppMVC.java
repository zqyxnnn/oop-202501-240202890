package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        // Gantilah [Nama]-[NIM] dengan identitas aslimu
        System.out.println("Hello, I am [Zakkya FAuzan Alba'asithu]-[230202890] (Week10)");
        
        // 1. Inisialisasi Model
        Product product = new Product("P01", "Pupuk Organik");
        
        // 2. Inisialisasi View
        ConsoleView view = new ConsoleView();
        
        // 3. Inisialisasi Controller (Menghubungkan Model dan View)
        ProductController controller = new ProductController(product, view);
        
        // 4. Jalankan aplikasi
        controller.showProduct();
    }
}