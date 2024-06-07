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
public class pemesan {
    private String databaseName = "2210010194";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public pemesan(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanPemesan(String id, String nama, String email, String no_hp, String alamat){
        try {
            String sql = "insert into pemesan(id, nama, email, no_hp, alamat) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, nama);
            perintah.setString(3, email);
            perintah.setString(4, no_hp);
            perintah.setString(5, alamat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahPemesan(String id, String nama, String email, String no_hp, String alamat){
        try {
            String sql = "update pemesan set nama = ?, email = ?, no_hp = ?, alamat = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, email);
            perintah.setString(3, no_hp);
            perintah.setString(4, alamat);
            perintah.setString(5, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPemesan(String id){
        try {
            String sql = "delete from pemesan where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariPemesan(String id){
        try {
            String sql = "select * from pemesan where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("ID : "+data.getString("id"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("EMAIL : "+data.getString("email"));
                System.out.println("NO HANDPHONE : "+data.getString("no_hp"));
                System.out.println("ALAMAT : "+data.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPemesan(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from pemesan order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("email")+" | "+
                        baris.getString("no_hp")+" | "+
                        baris.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        
}
