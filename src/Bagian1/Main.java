package Bagian1;

public class Main {
 public static void main(String[] args) {
  // Membuat objek buku pertama
  Buku buku1 = new Buku("Harry Potter", "J.K. Rowling", 300000);

  // Membuat objek buku kedua
  Buku buku2 = new Buku("UML", "Ivar Jacobson", 400000);

  // Menampilkan informasi buku ke layar (cmd)
  System.out.println("Judul\t\tPengarang\tHarga");
  System.out.println(buku1.getJudul() + "\t" + buku1.getPengarang() + "\t" + buku1.getHarga());
  System.out.println(buku2.getJudul() + "\t\t" + buku2.getPengarang() + "\t" + buku2.getHarga());
 }
}
