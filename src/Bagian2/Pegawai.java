package Bagian2;

public class Pegawai {
 private String id;
 private String nama;
 private String alamat;
 private String departemen;
 private double gaji;

 public Pegawai(String id, String nama, String alamat, String departemen, double gaji) {
  this.id = id;
  this.nama = nama;
  this.alamat = alamat;
  this.departemen = departemen;
  this.gaji = gaji;
 }

 public String getId() {
  return id;
 }

 public String getNama() {
  return nama;
 }

 public String getAlamat() {
  return alamat;
 }

 public String getDepartemen() {
  return departemen;
 }

 public double getGaji() {
  return gaji;
 }
}
