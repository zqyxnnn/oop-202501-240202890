# Laporan Praktikum Minggu 9

Topik: Exception Handling dan Custom Exception pada Agri-POS

## Identitas

* **Nama** : Zakkya Fauzan Ala'asithu
* **NIM** : 240202890
* **Kelas** : 3IKRA

---

## Tujuan

1. Mahasiswa mampu membedakan antara *Error* dan *Exception*.
2. Mahasiswa mampu mengimplementasikan blok `try-catch-finally` untuk menangani kesalahan *runtime*.
3. Mahasiswa dapat membuat dan menerapkan *Custom Exception* untuk validasi logika bisnis pada aplikasi keranjang belanja.

---

## Dasar Teori

1. **Exception vs Error**: *Exception* adalah kondisi tidak normal yang dapat ditangani oleh program (misal: input salah), sedangkan *Error* adalah masalah fatal pada level sistem/JVM yang tidak bisa dipulihkan (misal: *OutOfMemory*).
2. **Try-Catch-Finally**: Struktur untuk menangani eksepsi; `try` untuk kode berisiko, `catch` untuk menangkap kesalahan, dan `finally` untuk menjalankan kode pembersihan yang selalu dieksekusi.
3. **Custom Exception**: Class pengecualian yang dibuat sendiri dengan mewarisi class `Exception` guna memberikan pesan error yang lebih spesifik bagi pengguna.

---

## Langkah Praktikum

1. **Setup Project**: Membuat folder proyek `week9-exception-handling` dan struktur package `com.upb.agripos`.
2. **Coding Custom Exception**: Membuat class `InvalidQuantityException`, `ProductNotFoundException`, dan `InsufficientStockException`.
3. **Coding Business Logic**: Membuat class `Product` dan `ShoppingCart` yang melempar (*throw*) eksepsi jika validasi gagal.
4. **Testing**: Membuat `MainExceptionDemo` untuk menguji skenario error (jumlah negatif, produk tidak ada, stok kurang).
5. **Execution**: Menjalankan kode melalui terminal VS Code dan memastikan semua eksepsi tertangkap dengan benar.

---

## Kode Program

### 1. Custom Exceptions

```java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { super(msg); }
}

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) { super(msg); }
}

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String msg) { super(msg); }
}

```

### 2. Logic Keranjang (ShoppingCart)

```java
public void addProduct(Product p, int qty) throws InvalidQuantityException {
    if (qty <= 0) throw new InvalidQuantityException("Quantity (" + qty + ") harus > 0");
    items.put(p, items.getOrDefault(p, 0) + qty);
}

public void checkout() throws InsufficientStockException {
    for (Map.Entry<Product, Integer> entry : items.entrySet()) {
        if (entry.getKey().getStock() < entry.getValue()) {
            throw new InsufficientStockException("Stok " + entry.getKey().getName() + " tidak cukup.");
        }
    }
}

```

---

## Hasil Eksekusi

<img width="1200" height="297" alt="Screenshot 2026-01-12 014712" src="https://github.com/user-attachments/assets/c0a7a137-30db-4f5c-95ce-4106b26e8cbb" />


---

## Analisis

* **Alur Kode**: Saat `cart.addProduct(p1, -1)` dipanggil, program masuk ke blok `if` validasi dan melakukan `throw new InvalidQuantityException`. Aliran program langsung berpindah ke blok `catch` di `MainExceptionDemo`.
* **Pendekatan**: Berbeda dengan minggu lalu yang mungkin menggunakan `if-else` biasa, minggu ini menggunakan *Exception Handling* sehingga pemisahan antara logika bisnis dan logika penanganan kesalahan menjadi lebih bersih.
* **Kendala**: Munculnya error *"non-project file"* di VS Code.
* **Solusi**: Diatasi dengan membuka folder spesifik tugas menggunakan *Open Folder* dan membersihkan *Java Language Server Workspace*.

---

## Kesimpulan

Penggunaan *Custom Exception* membuat aplikasi Agri-POS lebih profesional dan aman, karena setiap kesalahan logika (seperti stok kurang) memiliki identitas error yang jelas dan tidak menghentikan program secara paksa.

---

## Tugas Individu (Summary)

* **Fitur**: Validasi input jumlah barang, validasi keberadaan produk saat penghapusan, dan validasi stok saat *checkout*.
* **Pesan Kesalahan**: Pesan dibuat informatif dengan mencantumkan nama produk atau jumlah yang salah.
* **Commit Message**: `week9-exception: [fitur] implementasi 3 custom exception pada shopping cart`

---

## Quiz Minggu 9

1. **Perbedaan Error dan Exception**: Error adalah masalah berat di level JVM (fatal), sedangkan Exception adalah masalah logika program yang bisa ditangkap dan diperbaiki saat runtime.
2. **Fungsi Finally**: Digunakan untuk menjamin eksekusi kode tertentu (seperti menutup koneksi database atau mencetak status akhir) terlepas dari apakah ada error atau tidak.
3. **Pentingnya Custom Exception**: Agar programmer bisa memberikan label error yang spesifik sesuai kebutuhan bisnis, bukan sekadar menggunakan error generik dari Java.
4. **Contoh Kasus POS**: `ExpiredProductException` saat kasir memindai barang kedaluwarsa, atau `InvalidMemberIDException` saat kartu member tidak terdaftar.
