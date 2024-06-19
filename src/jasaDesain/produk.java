/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jasaDesain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class produk {
    private String databaseName = "2210010194";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public produk(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }
    
    public void simpanProduk(String id, String id_desainer, String nama, String kategori, String harga){
        try {
            String sql = "insert into produk (id, id_desainer, nama, kategori, harga) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, id_desainer);
            perintah.setString(3, nama);
            perintah.setString(4, kategori);
            perintah.setString(5, harga);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahProduk (String id, String id_desainer, String nama, String kategori, String harga){
        try {
            String sql = "update produk set id_desainer = ?, nama = ?, kategori = ?, harga = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_desainer);
            perintah.setString(2, nama);
            perintah.setString(3, kategori);
            perintah.setString(4, harga);
            perintah.setString(5, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusProduk(String id){
        try {
            String sql = "delete from produk where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariProduk(String id){
        try {
            String sql = "select * from produk where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID : "+data.getString("id"));
                System.out.println("ID DESAINER : "+data.getString("id_desainer"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("KATEGORI : "+data.getString("kategori"));
                System.out.println("HARGA : "+data.getString("harga"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataProduk(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from produk order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("id_desainer")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("kategori")+" | "+
                        baris.getString("harga"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
//    private int idProduk;
//    private int idDesainer;
//    private String namaProduk;
//    private String kategori;
//    private String deskripsi;
//    private String harga;
//    private LocalDate tanggal;
//    private String status;
//    private String fotoProduk;
//    
//    public produk(int idProduk, int idDesainer, String namaProduk, String kategori, String deskripsi, String harga,
//                  LocalDate tanggal, String status, String fotoProduk) {
//        this.idProduk = idProduk;
//        this.idDesainer = idDesainer;
//        this.namaProduk = namaProduk;
//        this.kategori = kategori;
//        this.deskripsi = deskripsi;
//        this.harga = harga;
//        this.tanggal = tanggal;
//        this.status = status;
//        this.fotoProduk = fotoProduk;
//    }
//
//    public int getIdProduk() {
//        return idProduk;
//    }
//
//    public void setIdProduk(int idProduk) {
//        this.idProduk = idProduk;
//    }
//
//    public int getIdDesainer() {
//        return idDesainer;
//    }
//
//    public void setIdDesainer(int idDesainer) {
//        this.idDesainer = idDesainer;
//    }
//
//    public String getNamaProduk() {
//        return namaProduk;
//    }
//
//    public void setNamaProduk(String namaProduk) {
//        this.namaProduk = namaProduk;
//    }
//
//    public String getKategori() {
//        return kategori;
//    }
//
//    public void setKategori(String kategori) {
//        this.kategori = kategori;
//    }
//
//    public String getDeskripsi() {
//        return deskripsi;
//    }
//
//    public void setDeskripsi(String deskripsi) {
//        this.deskripsi = deskripsi;
//    }
//
//    public String getHarga() {
//        return harga;
//    }
//
//    public void setHarga(String harga) {
//        this.harga = harga;
//    }
//
//    public LocalDate getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(LocalDate tanggal) {
//        this.tanggal = tanggal;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getFotoProduk() {
//        return fotoProduk;
//    }
//
//    public void setFotoProduk(String fotoProduk) {
//        this.fotoProduk = fotoProduk;
//    }
//
//    @Override
//    public String toString() {
//        return "Produk [idProduk=" + idProduk + ", idDesainer=" + idDesainer + ", namaProduk=" + namaProduk
//                + ", kategori=" + kategori + ", deskripsi=" + deskripsi + ", harga=" + harga + ", tanggal=" + tanggal
//                + ", status=" + status + ", fotoProduk=" + fotoProduk + "]";
    

