# Laporan Praktikum Minggu 6

Topik: Desain Arsitektur Sistem dengan UML dan Prinsip SOLID

## Identitas

* Nama  : Zakkya Fauzan Alba'asithu
* NIM   : 240202890
* Kelas : 3IKRA

---

## Tujuan

1. Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML.
2. Mahasiswa mampu menggambar UML Class Diagram dengan relasi antar class yang tepat.
3. Mahasiswa mampu menerapkan prinsip SOLID (terutama DIP dan OCP) dalam desain dan kode program.

---

## Dasar Teori

1. **UML (Unified Modeling Language)**: Bahasa standar untuk memvisualisasikan, menentukan, membangun, dan mendokumentasikan artefak sistem perangkat lunak.
2. **Single Responsibility Principle (SRP)**: Sebuah kelas harus hanya memiliki satu alasan untuk berubah, artinya satu kelas fokus pada satu fungsi saja.
3. **Open/Closed Principle (OCP)**: Entitas perangkat lunak harus terbuka untuk ekstensi tetapi tertutup untuk modifikasi.
4. **Dependency Inversion Principle (DIP)**: Bergantunglah pada abstraksi (interface), bukan pada implementasi konkret.

---

## Langkah Praktikum

1. **Setup**: Menyiapkan struktur folder `src/main/java/com/upb/agripos` untuk kode Java dan `src/uml` untuk file Mermaid.
2. **Coding**: Mengimplementasikan interface `PaymentMethod` serta kelas `CashPayment`, `EWalletPayment`, dan `PaymentService` untuk menerapkan prinsip SOLID.
3. **Designing**: Membuat diagram Use Case, Activity, Sequence, dan Class menggunakan sintaks Mermaid di VS Code.
4. **Commit**: Melakukan commit incremental dengan pesan `week6-uml-solid: iterasi-N <deskripsi>`.

---

## Kode Program

Implementasi prinsip **Dependency Inversion** pada `PaymentService`:

```java
package com.upb.agripos;

// PaymentService bergantung pada interface PaymentMethod (DIP)
public class PaymentService {
    private PaymentMethod method;

    public PaymentService(PaymentMethod method) {
        this.method = method;
    }

    public void checkout(double total) {
        System.out.println("=== Agri-POS Transaction ===");
        method.processPayment(total);
    }
}

```

---

## Hasil Eksekusi

1. **Diagram UML**:

   **Use Case Diagram**
    <img width="734" height="336" alt="Screenshot 2026-01-12 025141" src="https://github.com/user-attachments/assets/5cd25b83-3895-41e3-b2c2-fc2178c8120b" />

   **Activity Diagram**
    <img width="748" height="504" alt="Screenshot 2026-01-12 025205" src="https://github.com/user-attachments/assets/c2b79fd5-f13c-4a1e-b09c-b27cb34982ba" />

   **Sequence Diagram**
    <img width="746" height="577" alt="Screenshot 2026-01-12 025244" src="https://github.com/user-attachments/assets/7d6aa2dc-9592-4113-9c8b-25182e581174" />

   **Class Diagram**
    <img width="646" height="550" alt="Screenshot 2026-01-12 025313" src="https://github.com/user-attachments/assets/1d67c0e6-fdc1-4c36-a979-747a63ee07c9" />

3. **Output Program**:
```bash
=== Agri-POS Transaction ===
Pembayaran Tunai Berhasil: Rp50000.0

```



---

## Analisis

* **Cara Kerja Kode**: `MainApp` menentukan metode pembayaran yang akan digunakan (misal `CashPayment`) lalu menyuntikkannya (*injection*) ke dalam `PaymentService`. `PaymentService` kemudian menjalankan perintah pembayaran tanpa perlu tahu detail teknis di dalam kelas pembayaran tersebut.
* **Perbedaan Pendekatan**: Minggu ini menggunakan **Interface** dan **Abstraksi**. Sebelumnya, kode mungkin ditulis secara prosedural di dalam satu kelas besar, namun sekarang sudah modular sehingga mematuhi prinsip OCP.
* **Kendala**: Kesalahan sintaks pada Mermaid (`syntax error`). Solusinya adalah menyederhanakan penulisan tipe data dan memastikan penulisan `<<interface>>` benar tanpa spasi.

---

## Kesimpulan

Penerapan prinsip SOLID dan dokumentasi UML membuat sistem Agri-POS lebih *maintainable* dan *extensible*. Dengan DIP, kita bisa menambah metode pembayaran baru (seperti QRIS atau Transfer Bank) di masa depan tanpa harus merubah kode pada kelas `PaymentService` yang sudah ada.

---

## Quiz

1. **Aggregation vs Composition**:
* **Aggregation**: Hubungan "memiliki" yang lemah. Contoh: Kelas `Toko` memiliki `Product`. Jika Toko dihapus, data Produk tetap ada secara independen.
* **Composition**: Hubungan "memiliki" yang kuat. Contoh: Kelas `Transaksi` memiliki `ItemTransaksi`. Jika Transaksi dihapus, maka ItemTransaksi di dalamnya otomatis ikut terhapus karena tidak bisa berdiri sendiri.
2. **Prinsip Open/Closed**: Prinsip ini memastikan sistem mudah dikembangkan karena kita cukup menambahkan kelas baru (ekstensi) tanpa mengubah kode lama yang sudah stabil (modifikasi). Hal ini meminimalkan risiko munculnya *bug* baru pada fitur yang sudah berjalan.
3. **DIP & Testability**: DIP meningkatkan *testability* karena kita bisa mengganti objek asli dengan objek tiruan (*Mock Object*) saat pengujian. Contoh: Saat menguji `PaymentService`, kita bisa mengirimkan `MockPayment` yang selalu mengembalikan status "Berhasil" tanpa harus benar-benar memotong saldo e-wallet asli.
