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
public class View_Buku extends JFrame{
    JLabel lKode = new JLabel(" Kode Buku : ");
    JTextField tfKode = new JTextField();
    JLabel lJudul = new JLabel(" Judul Buku : ");
    JTextField tfJudul = new JTextField();
    JLabel lPengarang = new JLabel (" Nama Pengarang : ");
    JTextField tfPengarang = new JTextField();
    JLabel lPenerbit = new JLabel (" Nama Penerbit : ");
    JTextField tfPenerbit = new JTextField();
    JLabel lTahun = new JLabel (" Tahun Terbit : ");
    JTextField tfTahun = new JTextField();
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton (" SIMPAN ");
    JButton btnHapus = new JButton (" HAPUS ");
    JButton btnCari = new JButton (" CARI ");
    JButton btnKeluar = new JButton (" KELUAR ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode Buku","Judul Buku","Pengarang","Penerbit","Tahun Terbit"};
    
    public View_Buku(){
    tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,500);
        add(lKode);
        lKode.setBounds(10,30,300,20);
        add(tfKode);
        tfKode.setBounds(200,30,200,20);
        add(lJudul);
        lJudul.setBounds(10,60,300,20);
        add(tfJudul);
        tfJudul.setBounds(200,60,200,20);
        add(lPengarang);
        lPengarang.setBounds(10,90,300,20);
        add(tfPengarang);
        tfPengarang.setBounds(200,90,200,20);
        add(lPenerbit);
        lPenerbit.setBounds(10,120,300,20);
        add(tfPenerbit);
        tfPenerbit.setBounds(200,120,200,20);
        add(lTahun);
        lTahun.setBounds(10,150,300,20);
        add(tfTahun);
        tfTahun.setBounds(200,150,200,20);
        add(btnRefresh);
        btnRefresh.setBounds(500,60,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(610,60,100,20);
        add(btnHapus);
        btnHapus.setBounds(500,120,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(610,120,100,20);
        add(scrollPane);
        scrollPane.setBounds(10,250,650,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setVisible(true);
    }
    
    public String getKode(){
        return tfKode.getText();
    }
    public String getJudul(){
        return tfJudul.getText();
    }
    public String getPengarang(){
        return tfPengarang.getText();
    }
    public String getPenerbit(){
        return tfPenerbit.getText();
    }
    public String getTahun(){
        return tfTahun.getText();
    }
}
