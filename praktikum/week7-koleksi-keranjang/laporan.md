# Laporan Praktikum Minggu 7

Topik: Java Collections (ArrayList dan Map)

## Identitas

* **Nama**  : Zakkya Fauzan Alba'asithu
* **NIM**   : 240202890
* **Kelas** : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami arsitektur **Java Collections Framework** serta mengimplementasikan penggunaan `ArrayList` dan `HashMap` dalam membangun sistem keranjang belanja yang dinamis.

---

## Dasar Teori

1. **Collections Framework**: Sebuah struktur penyimpanan data objek yang fleksibel dan ukurannya dapat berubah secara dinamis sesuai kebutuhan program.
2. **ArrayList**: Koleksi berbasis urutan (Index-based) yang memungkinkan penyimpanan data berulang. Sangat efisien untuk iterasi data.
3. **HashMap**: Koleksi berbasis pasangan kunci-nilai (*Key-Value*). Memungkinkan pemetaan satu objek unik ke nilai tertentu, seperti produk ke jumlah belanjanya.
4. **Enkapsulasi**: Penggunaan akses kontrol `private` pada atribut class untuk menjaga integritas data melalui method *getter*.

---

## Langkah Praktikum

1. Membuat class **`Product`** untuk menyimpan detail data barang.
2. Membuat class **`ShoppingCart`** dengan `ArrayList` untuk daftar belanja sederhana.
3. Membuat class **`ShoppingCartMap`** dengan `HashMap` untuk fitur pengelompokan produk dan kuantitas (Quantity).
4. Membuat class **`MainCart`** sebagai program utama untuk menjalankan pengujian.
5. Memastikan semua nama file diawali huruf kapital sesuai aturan **PascalCase** Java agar tidak terjadi error.

---

## Kode Program

### 1. Product.java

```java
package com.upb.agripos;

public class Product {
    private String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

```

### 2. ShoppingCart.java (Versi ArrayList)

```java
package com.upb.agripos;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double total = 0;
        for (Product p : items) { total += p.getPrice(); }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (ArrayList):");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}

```

### 3. ShoppingCartMap.java (Versi HashMap)

```java
package com.upb.agripos;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { 
        items.put(p, items.getOrDefault(p, 0) + 1); 
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
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

```

### 4. MainCart.java

```java
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // IDENTITAS MAHASISWA
        System.out.println("Hello, I am Zakkya Fauzan Alba'asithu-240202890 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        // Bagian 2: ArrayList
        System.out.println("\n=== Testing ArrayList Version ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        // Bagian 4: Map
        System.out.println("\n=== Testing Map Version (Quantity) ===");
        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.addProduct(p1);
        cartMap.addProduct(p1); // Beras otomatis masuk ke kuantitas x2
        cartMap.addProduct(p2);
        cartMap.printCart();
    }
}

```

---

## Hasil Eksekusi

![alt text](<Screenshot 2026-01-05 022052.png>)

---

## Analisis

* **Logika Program**: Penggunaan `ArrayList` bersifat linear, sehingga setiap data baru akan menempati alamat memori baru secara berurutan. Sebaliknya, `HashMap` menggunakan kode hash unik dari objek `Product` untuk mengecek duplikasi; jika produk sudah ada, maka hanya nilai kuantitasnya yang diperbarui.
* **Efisiensi**: Versi `Map` lebih ringkas dalam penyajian data karena menghindari redundansi penulisan nama produk yang sama di terminal.
* **Penanganan Error**: Pentingnya penggunaan nama file yang diawali huruf kapital sangat terasa di sini, karena Java compiler akan gagal memproses class jika nama file tidak presisi.

---

## Kesimpulan

Pemilihan jenis koleksi sangat menentukan kualitas aplikasi. Untuk fitur keranjang belanja modern, `HashMap` memberikan solusi yang lebih matang dibandingkan `ArrayList` karena kemampuannya dalam mengelola kuantitas barang secara otomatis dan akurat.

---

## Quiz

1. **Jelaskan perbedaan mendasar antara List, Map, dan Set.**
**Jawaban:** `List` menyimpan data secara berurut (indeks) dan mengizinkan duplikat. `Set` menyimpan data unik dan menolak duplikat. `Map` menyimpan data dalam pasangan Key-Value untuk memetakan hubungan antar objek.
2. **Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?**
**Jawaban:** Karena implementasinya mudah dan kinerjanya cepat untuk operasi penambahan barang satu per satu tanpa memerlukan logika unik yang rumit.
3. **Bagaimana struktur Set mencegah duplikasi data?**
**Jawaban:** `Set` melakukan pengecekan `hashCode()` dan `equals()` pada setiap objek baru. Jika ditemukan objek dengan nilai identik, data baru tersebut tidak akan dimasukkan.
4. **Kapan sebaiknya menggunakan Map dibandingkan List?**
**Jawaban:** Saat kita perlu mengelompokkan data berdasarkan kategori tertentu, seperti memetakan Produk ke jumlah stoknya atau jumlah belanjanya.