import java.util.*;
import java.util.stream.*;

public class HelloFunctional {
   public static void main(String[] args) {
      String nim = "240202890";
      String nama = "Fauzan";

      List<String> produk = Arrays.asList("Kentang Goreng", "Ayam Goreng", "Bebek Goreng");
      List<Integer> harga = Arrays.asList(10000, 15000, 18000);

      System.out.println("Nama: " + nama + ", NIM: " + nim);
      System.out.println("Daftar Produk:");
      IntStream.range(0, produk.size())
         .forEach(i -> System.out.println("- " + produk.get(i) + ": " + harga.get(i)));

      int total = harga.stream().mapToInt(Integer::intValue).sum();
      System.out.println("Total harga semua produk: " + total);
   }
}