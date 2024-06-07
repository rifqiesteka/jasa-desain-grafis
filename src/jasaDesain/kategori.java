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
public class kategori {
    private String databaseName = "2210010194";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public kategori(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanKategori(String id, String nama_kategori){
        try {
            String sql = "insert into kategori(id, nama_kategori) value (?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, nama_kategori);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahKategori(String id, String nama_kategori){
        try {
            String sql = "update kategori set nama_kategori = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama_kategori);
            perintah.setString(2, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusKategori(String id){
        try {
            String sql = "delete from kategori where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariKategori(String id){
        try {
            String sql = "select * from kategori where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID : "+data.getString("id"));
                System.out.println("NAMA KATEGORI : "+data.getString("nama_kategori"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataKategori(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from kategori order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("nama_kategori"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
