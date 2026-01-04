# Laporan Praktikum Minggu 5

Topik: **Abstraction (Abstract Class & Interface)**

## Identitas

* Nama  : Zakkya Fauzan Alba'asithu
* NIM   : 240202890
* Kelas :3IKRA

---

## Tujuan

* Mahasiswa mampu menjelaskan perbedaan *abstract class* dan *interface*.
* Mahasiswa mampu mendesain *abstract class* dengan method abstrak sesuai kebutuhan.
* Mahasiswa mampu menerapkan *multiple inheritance* melalui *interface* pada Java.

---

## Dasar Teori

1. **Abstraction**: Proses menyembunyikan detail implementasi dan hanya menampilkan fungsi penting kepada pengguna.
2. **Abstract Class**: Kelas yang tidak bisa diinstansiasi secara langsung dan dapat memiliki method abstrak serta variabel (*state*).
3. **Interface**: Kumpulan kontrak method tanpa implementasi (sebelum Java 8) yang memungkinkan sebuah kelas memiliki banyak kemampuan (*multiple inheritance*).
4. **Polimorfisme**: Kemampuan objek untuk mengambil berbagai bentuk, dalam hal ini menggunakan tipe data parent (*Pembayaran*) untuk objek anak (*Cash*/*EWallet*).

---

## Langkah Praktikum

1. Setup struktur folder berbasis package: `com.upb.agripos.model.pembayaran`, `model.kontrak`, dan `util`.
2. Membuat interface `Validatable` (untuk verifikasi) dan `Receiptable` (untuk cetak struk).
3. Membuat abstract class `Pembayaran` sebagai induk dari semua metode bayar.
4. Membuat class konkrit `Cash` (pembayaran tunai) dan `EWallet` (pembayaran digital dengan validasi OTP).
5. Membuat utilitas `CreditBy` untuk menampilkan identitas pengembang.
6. Menjalankan simulasi transaksi di `MainAbstraction.java`.
7. Melakukan commit Git dengan pesan `week5-abstraction-interface`.

---

## Kode Program

Contoh implementasi polimorfisme dan *interface casting* pada `MainAbstraction.java`:

```java
Pembayaran bayar1 = new Cash("INV-001", 50000, 100000);
Pembayaran bayar2 = new EWallet("INV-002", 75000, "0812345678", "123456");

System.out.println(((Receiptable) bayar1).cetakStruk());
System.out.println(((Receiptable) bayar2).cetakStruk());

CreditBy.print("240202890", "Zakkya Fauzan Alba'asithu");

```

---

## Hasil Eksekusi

![alt text](<Screenshot 2026-01-05 033013.png>)

## Analisis

* **Cara Kerja**: Kode berjalan dengan menggunakan kelas `Pembayaran` sebagai referensi. Saat `cetakStruk()` dipanggil, program melakukan *casting* ke interface `Receiptable`. Untuk `EWallet`, biaya otomatis ditambahkan sebesar 1.5% melalui override method `biaya()`.
* **Perbedaan Pendekatan**: Minggu ini menggunakan **Abstraction**. Kita tidak bisa membuat objek `new Pembayaran()`, melainkan harus melalui kelas anaknya. Ini lebih aman karena mencegah adanya data pembayaran yang tidak jelas jenisnya.
* **Kendala**: Kesalahan deklarasi `package` yang menyertakan folder `src.main`. Solusinya adalah memperbaiki deklarasi package agar dimulai langsung dari `com.upb...` dan melakukan *Clean Java Language Server*.

---

## Kesimpulan

Penggunaan *abstract class* sangat efektif untuk mendefinisikan sifat umum (seperti total harga), sedangkan *interface* sangat fleksibel untuk menambahkan kemampuan spesifik (seperti validasi) yang tidak dimiliki oleh semua kelas anak.

---

## Quiz

1. **Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.**
* **Jawaban:** *Abstract class* digunakan untuk kelas yang memiliki hubungan "Is-A" (adalah sebuah) dan bisa memiliki variabel (*state*). *Interface* digunakan untuk mendefinisikan kemampuan "Can-Do" (bisa melakukan) dan mendukung *multiple inheritance*.


2. **Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?**
* **Jawaban:** Karena interface hanya berisi deklarasi method tanpa implementasi (sebelum Java 8). Hal ini menghindari konflik jika dua parent memiliki method dengan nama yang sama namun isinya berbeda (*diamond problem*).


3. **Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya.**
* **Jawaban:** `Pembayaran` menjadi *abstract class* karena semua jenis pembayaran pasti memiliki data yang sama seperti `total` dan `invoiceNo`. Sedangkan `Validatable` menjadi *interface* karena tidak semua metode pembayaran butuh validasi (contoh: *Cash* tidak butuh OTP, sedangkan *E-Wallet* butuh).
