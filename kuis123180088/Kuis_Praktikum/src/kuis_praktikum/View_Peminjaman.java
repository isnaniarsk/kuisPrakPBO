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
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class View_Peminjaman extends JFrame {
    JLabel lNo = new JLabel(" Nomor Peminjaman : ");
    JTextField tfNo = new JTextField();
    JLabel lNIM = new JLabel(" NIM : ");
    JTextField tfNIM = new JTextField();
    JLabel lNama = new JLabel(" Nama Mahasiswa : ");
    JTextField tfNama = new JTextField();
    JLabel lKelas = new JLabel(" Kelas : ");
    JTextField tfKelas = new JTextField();
    JLabel lKode = new JLabel(" Kode Buku : ");
    JTextField tfKode = new JTextField();
    JLabel lJudul = new JLabel(" Judul Buku : ");
    JTextField tfJudul = new JTextField();
    JLabel lPenerbit = new JLabel(" Penerbit : ");
    JTextField tfPenerbit = new JTextField();
    JLabel lTglPinjam = new JLabel(" Tanggal Pinjam : ");
    JTextField tfTglPinjam = new JTextField();
    JLabel lTglKembali = new JLabel(" Tanggal Kembali : ");
    JTextField tfTglKembali = new JTextField();
    JLabel lLama = new JLabel(" Lama : ");
    JTextField tfLama = new JTextField();
    JLabel lDenda = new JLabel(" Denda : ");
    JTextField tfDenda = new JTextField();
    JLabel lNIK = new JLabel(" NIK : ");
    JTextField tfNIK = new JTextField();
    JLabel lNamaKar = new JLabel(" Nama Petugas : ");
    JTextField tfNamaKar = new JTextField();
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No Peminjaman","NIM","Nama Mhs","Kelas","Kode Buku","Nama Buku","Penerbit","Tanggal Pinjam", "Tanggal Kembali", "Lama",
                          "Denda", "Petugas", "NIK" };
    
    public View_Peminjaman(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,700);
        
        add(lNo);
        lNo.setBounds(10,30,300,20);
        add(tfNo);
        tfNo.setBounds(200,30,200,20);
        add(lNIM);
        lNIM.setBounds(10,60,300,20);
        add(tfNIM);
        tfNIM.setBounds(200,60,200,20);
        add(lNama);
        lNama.setBounds(10,90,300,20);
        add(tfNama);
        tfNama.setBounds(200,90,200,20);
        add(lKelas);
        lKelas.setBounds(10,120,300,20);
        add(tfKelas);
        tfKelas.setBounds(200,120,200,20);
        add(lKode);
        lKode.setBounds(10,150,300,20);
        add(tfKode);
        tfKode.setBounds(200,150,200,20);
        add(lJudul);
        lJudul.setBounds(10,180,300,20);
        add(tfJudul);
        tfJudul.setBounds(200,180,200,20);
        add(lPenerbit);
        lPenerbit.setBounds(10,210,300,20);
        add(tfPenerbit);
        tfPenerbit.setBounds(200,210,200,20);
        add(lTglPinjam);
        lTglPinjam.setBounds(10,240,300,20);
        add(tfTglPinjam);
        tfTglPinjam.setBounds(200,240,200,20);
        add(lTglKembali);
        lTglKembali.setBounds(10,270,300,20);
        add(tfTglKembali);
        tfTglKembali.setBounds(200,270,200,20);
        add(lLama);
        lLama.setBounds(460,30,120,20);
        add(tfLama);
        tfLama.setBounds(600,30,200,20);   
        add(lDenda);
        lDenda.setBounds(460,60,120,20);
        add(tfDenda);
        tfDenda.setBounds(600,60,200,20);   
        add(lNIK);
        lNIK.setBounds(460,90,120,20);
        add(tfNIK);
        tfNIK.setBounds(600,90,200,20);   
        add(lNamaKar);
        lNamaKar.setBounds(460,120,120,20);
        add(tfNamaKar);
        tfNamaKar.setBounds(600,120,200,20);   
        add(btnRefresh);
        btnRefresh.setBounds(550,150,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(680,150,100,20);
        add(btnHapus);
        btnHapus.setBounds(550,200,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(680,200,100,20);
        
        add(scrollPane);
        scrollPane.setBounds(40,350,750,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setVisible(true);
    }
    
    public String getNo(){
        return tfNo.getText();
    }
    public String getNIM(){
        return tfNIM.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
    public String getKelas(){
        return tfKelas.getText();
    }
    public String getKode(){
        return tfKode.getText();
    }
    public String getJudul(){
        return tfJudul.getText();
    }
    public String getPenerbit(){
        return tfPenerbit.getText();
    }
    public String getTglPinjam(){
        return tfTglPinjam.getText();
    }
    public String getTglKembali(){
        return tfTglKembali.getText();
    }
    public String getLama(){
        return tfLama.getText();
    }
    public String getDenda(){
        return tfDenda.getText();
    }
    public String getNIK(){
        return tfNIK.getText();
    }
    public String getPetugas(){
        return tfNamaKar.getText();
    }
}
