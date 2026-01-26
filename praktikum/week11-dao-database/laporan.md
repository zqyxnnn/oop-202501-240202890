# Laporan Praktikum Minggu 11

Topik: Data Access Object (DAO) dan CRUD Database dengan JDBC

## Identitas

* Nama  : Zakkya Fauzan Aklbaa'asithu
* NIM   : 240202890
* Kelas : 3IKRA

---

## Tujuan

1. Mahasiswa mampu menghubungkan aplikasi Java dengan database PostgreSQL menggunakan JDBC.
2. Mahasiswa mampu mengimplementasikan pola desain Data Access Object (DAO) untuk memisahkan logika akses data dengan logika bisnis.
3. Mahasiswa dapat melakukan operasi CRUD (Create, Read, Update, Delete) pada database melalui kode Java.

---

## Dasar Teori

1. **DAO (Data Access Object)**: Pola desain yang memisahkan logika akses data agar perubahan teknologi basis data tidak memengaruhi logika utama aplikasi.
2. **JDBC (Java Database Connectivity)**: API dari Java yang digunakan untuk menghubungkan dan mengeksekusi perintah pada database relasional.
3. **PreparedStatement**: Komponen JDBC yang digunakan untuk mengeksekusi query SQL secara aman dan mencegah serangan SQL Injection.
4. **CRUD**: Operasi dasar pada database yang terdiri dari *Create* (Insert), *Read* (Select), *Update*, dan *Delete*.

---

## Langkah Praktikum

1. **Setup Database**: Membuat database `agripos` dan tabel `products` di PostgreSQL melalui pgAdmin 4.
2. **Setup Project**: Membuat folder project di VS Code, menambahkan folder `lib` untuk menyimpan driver `postgresql-42.7.9.jar`, dan mendaftarkannya di *Referenced Libraries*.
3. **Coding**: Membuat class model `Product`, interface `ProductDAO`, implementasi `ProductDAOImpl`, dan kelas pengujian `MainDAOTest`.
4. **Execution**: Menjalankan kelas `MainDAOTest` untuk menguji alur koneksi dan operasi database.
5. **Version Control**: Melakukan commit dan push hasil pekerjaan ke GitHub sesuai instruksi.

---

## Kode Program (Utama)

Contoh integrasi DAO pada kelas `MainDAOTest`:

// Melakukan koneksi dan operasi CRUD
Connection conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/agripos", "postgres", "1234"
);

ProductDAO dao = new ProductDAOImpl(conn);

// Create & Update
dao.insert(new Product("P01", "Pupuk Organik", 25000, 10));
dao.update(new Product("P01", "Pupuk Organik Premium", 30000, 8));

// Read
Product p = dao.findByCode("P01");
System.out.println(p.getName()); // Output: Pupuk Organik Premium

// Delete
dao.delete("P01");

---

## Hasil Eksekusi

<img width="1061" height="134" alt="Screenshot 2026-01-26 163440" src="https://github.com/user-attachments/assets/c8d076b9-92aa-4099-a193-07423c778c85" />


---

## Analisis

* **Alur Kode**: Program dimulai dengan membuka koneksi JDBC, lalu objek `ProductDAOImpl` melakukan eksekusi SQL melalui `PreparedStatement`. Hasil query dipetakan kembali ke objek Java (`Product`).
* **Perbedaan**: Berbeda dengan praktikum sebelumnya yang hanya menyimpan data di memori (ArrayList), minggu ini data disimpan secara permanen di database PostgreSQL.
* **Kendala**: Terjadi error *Incorrect Package* karena ketidaksesuaian struktur folder `src/main/java`. **Solusi**: Merapikan folder agar folder `com` berada langsung di bawah `src` dan menyegarkan *Java Language Server* di VS Code.
* **Kendala Git**: Terjadi penolakan saat push (*rejected*). **Solusi**: Menggunakan `git push --force` untuk menyinkronkan riwayat lokal dengan repository GitHub yang baru dibuat.

---

## Kesimpulan

Penerapan pola DAO menggunakan JDBC membuat kode akses database menjadi lebih rapi dan modular. Penggunaan database memungkinkan penyimpanan data aplikasi yang bersifat *persistent* (tidak hilang saat aplikasi ditutup), yang merupakan standar dalam pengembangan aplikasi profesional.
