package com.upb.agripos;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        // Contoh Polimorfisme
        Pembayaran bayar1 = new Cash("INV-001", 50000, 100000);
        Pembayaran bayar2 = new EWallet("INV-002", 75000, "0812345678", "123456");

        System.out.println("=== HASIL PROSES PEMBAYARAN ===");
        System.out.println(((Receiptable) bayar1).cetakStruk());
        System.out.println(((Receiptable) bayar2).cetakStruk());

        // Ganti dengan NIM dan Nama kamu
        CreditBy.print("240202890", "Zakkya FAuzan Alba'asithu");
    }
}