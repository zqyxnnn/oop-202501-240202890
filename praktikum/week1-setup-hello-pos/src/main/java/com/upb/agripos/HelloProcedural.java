public class HelloProcedural {
   public static void main(String[] args) {
      String nim = "240202880";
      String nama = "Fauzan";
      String[] produk = {"Kentang Goreng", "Ayam Goreng", "Bebek Goreng"};
      int[] harga = {10000, 15000, 18000};
      int total = 0;

      System.out.println("Nama: " + nama + ", NIM: " + nim);
      System.out.println("Daftar Produk:");
      for (int i = 0; i < produk.length; i++) {
         System.out.println("- " + produk[i] + ": " + harga[i]);
         total += harga[i];
      }
      System.out.println("Total harga semua produk: " + total);
   }
}