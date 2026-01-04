class Produk {
   String nama;
   int harga;

   Produk(String nama, int harga) {
      this.nama = nama;
      this.harga = harga;
   }
}

public class HelloOOP {
   public static void main(String[] args) {
      String nim = "240202890";
      String namaMhs = "Fauzan";

      Produk[] daftar = {
         new Produk("Kentang Goreng", 10000),
         new Produk("Ayam Goreng", 15000),
         new Produk("Bebek Goreng", 18000)
      };

      int total = 0;
      System.out.println("Nama: " + namaMhs + ", NIM: " + nim);
      System.out.println("Daftar Produk:");
      for (Produk p : daftar) {
         System.out.println("- " + p.nama + ": " + p.harga);
         total += p.harga;
      }
      System.out.println("Total harga semua produk: " + total);
   }
}