package Bagian2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AplikasiPegawai {
 private static Map<String, List<Pegawai>> pegawaiDepartemen = new HashMap<>();

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  while (true) {
   System.out.println("\nMenu:");
   System.out.println("1. Input Pegawai");
   System.out.println("2. Edit Pegawai");
   System.out.println("3. Tampilkan Seluruh Data Pegawai");
   System.out.println("4. Tampilkan Data Pegawai per Departemen");
   System.out.println("5. Tampilkan Data Pegawai Berdasarkan Range Gaji");
   System.out.println("6. Keluar");

   System.out.print("Pilih menu (1/2/3/4/5/6): ");
   String pilihan = scanner.nextLine();

   switch (pilihan) {
    case "1":
     inputPegawai(scanner);
     break;
    case "2":
     editPegawai(scanner);
     break;
    case "3":
     tampilkanSeluruhData();
     break;
    case "4":
     tampilkanDataPerDepartemen(scanner);
     break;
    case "5":
     tampilkanDataBerdasarkanGaji(scanner);
     break;
    case "6":
     System.out.println("Terima kasih telah menggunakan aplikasi ini.");
     scanner.close();
     System.exit(0);
     break;
    default:
     System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
     break;
   }
  }
 }

 private static void inputPegawai(Scanner scanner) {
  System.out.print("Masukkan departemen (Sumber Daya Manusia/Keuangan/Produksi): ");
  String departemen = scanner.nextLine().toLowerCase();
  System.out.print("Masukkan ID pegawai: ");
  String id = scanner.nextLine();
  System.out.print("Masukkan nama pegawai: ");
  String nama = scanner.nextLine();
  System.out.print("Masukkan alamat pegawai: ");
  String alamat = scanner.nextLine();
  System.out.print("Masukkan gaji pegawai: ");
  double gaji = Double.parseDouble(scanner.nextLine());

  Pegawai pegawai = new Pegawai(id, nama, alamat, departemen, gaji);

  pegawaiDepartemen.computeIfAbsent(departemen, k -> new ArrayList<>()).add(pegawai);
  System.out.println("Data pegawai berhasil ditambahkan.");
 }

 private static void editPegawai(Scanner scanner) {
  System.out.print("Masukkan departemen (Sumber Daya Manusia/Keuangan/Produksi): ");
  String departemen = scanner.nextLine();
  System.out.print("Masukkan ID pegawai yang ingin diedit: ");
  String id = scanner.nextLine();

  List<Pegawai> pegawaiList = pegawaiDepartemen.get(departemen);

  if (pegawaiList != null) {
   for (Pegawai pegawai : pegawaiList) {
    if (pegawai.getId().equals(id)) {
     System.out.print("Masukkan nama pegawai yang baru: ");
     String namaBaru = scanner.nextLine();
     System.out.print("Masukkan alamat pegawai yang baru: ");
     String alamatBaru = scanner.nextLine();
     System.out.print("Masukkan gaji pegawai yang baru: ");
     double gajiBaru = Double.parseDouble(scanner.nextLine());

     pegawai = new Pegawai(id, namaBaru, alamatBaru, departemen, gajiBaru);
     System.out.println("Data pegawai berhasil diubah.");
     return;
    }
   }
   System.out.println("ID pegawai tidak ditemukan.");
  } else {
   System.out.println("Departemen tidak ditemukan.");
  }
 }

 private static void tampilkanSeluruhData() {
  for (Map.Entry<String, List<Pegawai>> entry : pegawaiDepartemen.entrySet()) {
   String departemen = entry.getKey();
   List<Pegawai> pegawaiList = entry.getValue();

   System.out.println("Departemen: " + departemen);
   for (Pegawai pegawai : pegawaiList) {
    System.out.println("ID: " + pegawai.getId() + ", Nama: " + pegawai.getNama() +
      ", Alamat: " + pegawai.getAlamat() + ", Gaji: " + pegawai.getGaji());
   }
  }
 }

 private static void tampilkanDataPerDepartemen(Scanner scanner) {
  System.out.print("Masukkan departemen (Sumber Daya Manusia/Keuangan/Produksi): ");
  String departemen = scanner.nextLine().toLowerCase();

  List<Pegawai> pegawaiList = pegawaiDepartemen.get(departemen);

  if (pegawaiList != null) {
   for (Pegawai pegawai : pegawaiList) {
    System.out.println("ID: " + pegawai.getId() + ", Nama: " + pegawai.getNama() +
      ", Alamat: " + pegawai.getAlamat() + ", Gaji: " + pegawai.getGaji());
   }
  } else {
   System.out.println("Departemen tidak ditemukan.");
  }
 }

 private static void tampilkanDataBerdasarkanGaji(Scanner scanner) {
  System.out.print("Masukkan gaji minimum: ");
  double gajiMin = Double.parseDouble(scanner.nextLine());

  for (Map.Entry<String, List<Pegawai>> entry : pegawaiDepartemen.entrySet()) {
   String departemen = entry.getKey();
   List<Pegawai> pegawaiList = entry.getValue();

   System.out.println("Departemen: " + departemen);
   for (Pegawai pegawai : pegawaiList) {
    if (pegawai.getGaji() > gajiMin) {
     System.out.println("ID: " + pegawai.getId() + ", Nama: " + pegawai.getNama() +
       ", Alamat: " + pegawai.getAlamat() + ", Gaji: " + pegawai.getGaji());
    }
   }
  }
 }
}
