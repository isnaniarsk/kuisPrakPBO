/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis_praktikum;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Model_Kuis {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/data";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public Model_Kuis() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
        public void insertAnggota(String nim, String nama, String ttl , String jeniskel, String agama, String kelas, String tanggal, String berlaku ){
            try {
                String query = " INSERT INTO `anggota`(`NIM`,`nama`,`TTL`,`jeniskel`,`agama`,`kelas`,`tanggal`,`berlaku`) VALUES ('"+nim+"','"+nama+"','"+ttl+"','"+jeniskel+"','"+agama+"','"+kelas+"','"+tanggal+"','"+berlaku+"')";
                statement = (Statement) koneksi.createStatement(); 
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");  
            }
            catch(Exception sql){
                System.out.println(sql.getMessage());
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        }
        
        public String[][] readAnggota(){
            try{
                int jmlAnggota = 0;
                String anggota[][] = new String[getBanyakAnggota()][8];
                String query = "SELECT * FROM `anggota`";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    anggota[jmlAnggota][0] = resultSet.getString("NIM");
                    anggota[jmlAnggota][1] = resultSet.getString("Nama");
                    anggota[jmlAnggota][2] = resultSet.getString("TTL");
                    anggota[jmlAnggota][3] = resultSet.getString("JenisKel");
                    anggota[jmlAnggota][4] = resultSet.getString("Agama");
                    anggota[jmlAnggota][5] = resultSet.getString("Kelas");
                    anggota[jmlAnggota][6] = resultSet.getString("Tanggal");
                    anggota[jmlAnggota][7] = resultSet.getString("Berlaku");
                    jmlAnggota++;
                } return anggota;
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
        }
        
        public int getBanyakAnggota(){
            int jmlAnggota = 0;
            try{
                statement = koneksi.createStatement();
                String query = "SELECT * FROM `anggota`";
                ResultSet resultSet =  statement.executeQuery(query);
                while(resultSet.next()){
                    jmlAnggota++;
                } return jmlAnggota;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return 0;
            }
        }
        
        public void deleteAnggota(String nim){
            try{
                String query = "DELETE FROM `anggota` WHERE `NIM` = '"+nim+"'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil dihapus");
            }
            catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
        
        public void insertBuku(String kode, String judul, String pengarang , String penerbit, String tahun){
            try {
                String query = " INSERT INTO `buku`(`kode`,`judul`,`pengarang`,`penerbit`,`tahun`) VALUES ('"+kode+"','"+judul+"','"+pengarang+"','"+penerbit+"','"+tahun+"')";
                statement = (Statement) koneksi.createStatement(); 
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");  
            }
            catch(Exception sql){
                System.out.println(sql.getMessage());
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        }
        
        public String[][] readBuku(){
            try{
                int jmlBuku = 0;
                String buku[][] = new String[getBanyakBuku()][5];
                String query = "SELECT * FROM `buku`";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    buku[jmlBuku][0] = resultSet.getString("Kode");
                    buku[jmlBuku][1] = resultSet.getString("Judul");
                    buku[jmlBuku][2] = resultSet.getString("Pengarang");
                    buku[jmlBuku][3] = resultSet.getString("Penerbit");
                    buku[jmlBuku][4] = resultSet.getString("Tahun");
                    jmlBuku++;
                } return buku;
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
        }
        
        public int getBanyakBuku(){
            int jmlBuku = 0;
            try{
                statement = koneksi.createStatement();
                String query = "SELECT * FROM `buku`";
                ResultSet resultSet =  statement.executeQuery(query);
                while(resultSet.next()){
                    jmlBuku++;
                } return jmlBuku;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return 0;
            }
        }
        
        public void deleteBuku(String kode){
            try{
                String query = "DELETE FROM `buku` WHERE `kode` = '"+kode+"'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil dihapus");
            }
            catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
        
       public void insertKaryawan(String nik, String namakar, String jeniskelamin , String golongan, String jabatan, String tunjangan, String gaji){
            try {
                String query = " INSERT INTO `karyawan`(`NIK`,`namakar`,`jeniskelamin`,`golongan`,`jabatan`,`tunjangan`,`gaji`) VALUES ('"+nik+"','"+namakar+"','"+jeniskelamin+"','"+jabatan+"','"+golongan+"','"+tunjangan+"','"+gaji+"')";
                statement = (Statement) koneksi.createStatement(); 
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");  
            }
            catch(Exception sql){
                System.out.println(sql.getMessage());
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        } 
       
       public String[][] readKaryawan(){
            try{
                int jmlKaryawan = 0;
                String karyawan[][] = new String[getBanyakKaryawan()][7];
                String query = "SELECT * FROM `karyawan`";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    karyawan[jmlKaryawan][0] = resultSet.getString("NIK");
                    karyawan[jmlKaryawan][1] = resultSet.getString("NamaKar");
                    karyawan[jmlKaryawan][2] = resultSet.getString("jeniskelamin");
                    karyawan[jmlKaryawan][3] = resultSet.getString("Golongan");
                    karyawan[jmlKaryawan][4] = resultSet.getString("Jabatan");
                    karyawan[jmlKaryawan][5] = resultSet.getString("Tunjangan");
                    karyawan[jmlKaryawan][6] = resultSet.getString("Gaji");
                    jmlKaryawan++;
                } return karyawan;
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
        }
       
       public int getBanyakKaryawan(){
            int jmlKaryawan = 0;
            try{
                statement = koneksi.createStatement();
                String query = "SELECT * FROM `karyawan`";
                ResultSet resultSet =  statement.executeQuery(query);
                while(resultSet.next()){
                    jmlKaryawan++;
                } return jmlKaryawan;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return 0;
            }
        }
       
       public void deleteKaryawan(String nik){
            try{
                String query = "DELETE FROM `karyawan` WHERE `NIK` = '"+nik+"'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil dihapus");
            }
            catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
       
       public void insertPeminjaman(String nomor, String NIM, String nama , String kelas, String kode, String judul, String penerbit, String tgl_pinjam, String tgl_kembali, String lama_pinjam, String denda, String NIK, String namakar){
            try {
                String query = " INSERT INTO `peminjaman`(`nomor`,`NIM`,`nama`,`kelas`,`kode`,`judul`,`penerbit`,`tgl_pinjam`,`tgl_kembali`,`lama_pinjam`,`denda`,`NIK`,`namakar`) VALUES ('"+nomor+"','"+NIM+"','"+nama+"','"+kelas+"','"+kode+"','"+judul+"','"+penerbit+"','"+tgl_pinjam+"','"+tgl_kembali+"','"+lama_pinjam+"','"+denda+"','"+NIK+"','"+namakar+"')";
                statement = (Statement) koneksi.createStatement(); 
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");  
            }
            catch(Exception sql){
                System.out.println(sql.getMessage());
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        }
       public String[][] readPeminjaman(){
           try{
                int jmlPeminjaman = 0;
                String peminjaman[][] = new String[getBanyakPeminjaman()][13];
                String query = "SELECT * FROM `peminjaman`";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    peminjaman[jmlPeminjaman][0] = resultSet.getString("nomor");
                    peminjaman[jmlPeminjaman][1] = resultSet.getString("NIM");
                    peminjaman[jmlPeminjaman][2] = resultSet.getString("nama");
                    peminjaman[jmlPeminjaman][3] = resultSet.getString("kelas");
                    peminjaman[jmlPeminjaman][4] = resultSet.getString("kode");
                    peminjaman[jmlPeminjaman][5] = resultSet.getString("judul");
                    peminjaman[jmlPeminjaman][6] = resultSet.getString("penerbit");
                    peminjaman[jmlPeminjaman][7] = resultSet.getString("tgl_pinjam");
                    peminjaman[jmlPeminjaman][8] = resultSet.getString("tgl_kembali");
                    peminjaman[jmlPeminjaman][9] = resultSet.getString("lama_pinjam");
                    peminjaman[jmlPeminjaman][10] = resultSet.getString("denda");
                    peminjaman[jmlPeminjaman][11] = resultSet.getString("NIK");
                    peminjaman[jmlPeminjaman][12] = resultSet.getString("namakar");
                    jmlPeminjaman++;
                }return peminjaman;
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
       }
       
       public int getBanyakPeminjaman(){
            int jmlPeminjaman = 0;
            try{
                statement = koneksi.createStatement();
                String query = "SELECT * FROM `peminjaman`";
                ResultSet resultSet =  statement.executeQuery(query);
                while(resultSet.next()){
                    jmlPeminjaman++;
                } return jmlPeminjaman;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return 0;
            }
        }
       public void deletePeminjaman(String no){
            try{
                String query = "DELETE FROM `peminjaman` WHERE `nomor` = '"+no+"'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil dihapus");
            }
            catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }   
}

   
    

