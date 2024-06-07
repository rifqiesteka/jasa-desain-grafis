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
public class desainer{
    private String databaseName = "2210010194";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public desainer(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanDesainer(String id, String nama, String email, String rating, String no_hp){
        try {
            String sql = "insert into desainer (id, nama, email, rating, no_hp) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, nama);
            perintah.setString(3, email);
            perintah.setString(4, rating);
            perintah.setString(5, no_hp);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahDesainer(String id, String nama, String email, String rating, String no_hp){
        try {
            String sql = "update desainer set nama = ?, email = ?, rating = ?, no_hp = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, email);
            perintah.setString(3, rating);
            perintah.setString(4, no_hp);
            perintah.setString(5, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusDesainer(String id){
        try {
            String sql = "delete from desainer where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariDesainer(String id){
        try {
            String sql = "select * from desainer where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID :"+data.getString("id"));
                System.out.println("NAMA :"+data.getString("nama"));
                System.out.println("EMAIL :"+data.getString("email"));
                System.out.println("RATING :"+data.getString("rating"));
                System.out.println("NO HANDPHONE :"+data.getString("no_hp"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataDesainer(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from desainer order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("email")+" | "+
                        baris.getString("rating")+" | "+
                        baris.getString("no_hp"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

//    private String username;
//    private String email;
//    private String namaDesainer;
//    private String tempatLahir;
//    private String jenisKelamin;
//    private String noHp;
//    private String alamat;
//    private String kecamatan;
//    private String kabupaten;
//    private String provinsi;
//    private String kodePos;
//    private String rating;
//    private LocalDate tanggalDaftar;
//    private String fotoProfil;
//    
//    public desainer(int idProduk, int idDesainer, String namaProduk, String kategori, String deskripsi, String harga, LocalDate tanggal, String status, String fotoProduk) {
//        super(idProduk, idDesainer, namaProduk, kategori, deskripsi, harga, tanggal, status, fotoProduk);
//        this.username = username;
//        this.email = email;
//        this.namaDesainer = namaDesainer;
//        this.tempatLahir = tempatLahir;
//        this.jenisKelamin = jenisKelamin;
//        this.noHp = noHp;
//        this.alamat = alamat;
//        this.kecamatan = kecamatan;
//        this.kabupaten = kabupaten;
//        this.provinsi = provinsi;
//        this.kodePos = kodePos;
//        this.rating = rating;
//        this.tanggalDaftar = tanggalDaftar;
//        this.fotoProfil = fotoProfil;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getNamaDesainer() {
//        return namaDesainer;
//    }
//
//    public void setNamaDesainer(String namaDesainer) {
//        this.namaDesainer = namaDesainer;
//    }
//
//    public String getTempatLahir() {
//        return tempatLahir;
//    }
//
//    public void setTempatLahir(String tempatLahir) {
//        this.tempatLahir = tempatLahir;
//    }
//
//    public String getJenisKelamin() {
//        return jenisKelamin;
//    }
//
//    public void setJenisKelamin(String jenisKelamin) {
//        this.jenisKelamin = jenisKelamin;
//    }
//
//    public String getNoHp() {
//        return noHp;
//    }
//
//    public void setNoHp(String noHp) {
//        this.noHp = noHp;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getKecamatan() {
//        return kecamatan;
//    }
//
//    public void setKecamatan(String kecamatan) {
//        this.kecamatan = kecamatan;
//    }
//
//    public String getKabupaten() {
//        return kabupaten;
//    }
//
//    public void setKabupaten(String kabupaten) {
//        this.kabupaten = kabupaten;
//    }
//
//    public String getProvinsi() {
//        return provinsi;
//    }
//
//    public void setProvinsi(String provinsi) {
//        this.provinsi = provinsi;
//    }
//
//    public String getKodePos() {
//        return kodePos;
//    }
//
//    public void setKodePos(String kodePos) {
//        this.kodePos = kodePos;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }
//
//    public LocalDate getTanggalDaftar() {
//        return tanggalDaftar;
//    }
//
//    public void setTanggalDaftar(LocalDate tanggalDaftar) {
//        this.tanggalDaftar = tanggalDaftar;
//    }
//
//    public String getFotoProfil() {
//        return fotoProfil;
//    }
//
//    public void setFotoProfil(String fotoProfil) {
//        this.fotoProfil = fotoProfil;
//    }
//
//    @Override
//    public String toString() {
//        return "Desainer [username=" + username + ", email=" + email + ", namaDesainer=" + namaDesainer
//                + ", tempatLahir=" + tempatLahir + ", jenisKelamin=" + jenisKelamin + ", noHp=" + noHp + ", alamat="
//                + alamat + ", kecamatan=" + kecamatan + ", kabupaten=" + kabupaten + ", provinsi=" + provinsi
//                + ", kodePos=" + kodePos + ", rating=" + rating + ", tanggalDaftar=" + tanggalDaftar + ", fotoProfil="
//                + fotoProfil + "]";


