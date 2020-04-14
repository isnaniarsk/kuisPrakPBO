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
public class View_Anggota extends JFrame{
    JLabel lNIM = new JLabel(" NIM : ");
    JTextField tfNIM = new JTextField();
    JLabel lNama = new JLabel(" Nama Mahasiswa : ");
    JTextField tfNama = new JTextField();
    JLabel lTTL = new JLabel(" TTL : ");
    JTextField tfTTL = new JTextField();
    JLabel lJenisKel = new JLabel(" Jenis Kelamin : ");
    JRadioButton rbPria = new JRadioButton(" Laki-laki ");
    JRadioButton rbWanita = new JRadioButton("Perempuan ");
    ButtonGroup jk = new ButtonGroup();
    JLabel lAgama = new JLabel(" Agama : ");
    String[] namaAgama =
        {"Islam", "Katolik", "Kristen", "Budha", "Hindu"};
    JComboBox cmbAgama = new JComboBox(namaAgama);
    JLabel lKelas = new JLabel(" Kelas : ");
    JTextField tfKelas = new JTextField();
    JLabel lTanggal  = new JLabel(" Tanggal Daftar : ");
    JTextField tfTanggal = new JTextField();
    JLabel lBerlaku = new JLabel(" Berlaku Hingga : ");
    JTextField tfBerlaku = new JTextField();
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama Mhs","TTL","Jenis Kelamin","Agama","Kelas","Tanggal Daftar", "Berlaku Hingga"};
    
    public View_Anggota(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,700);
        add(lNIM);
        lNIM.setBounds(10,30,300,20);
        add(tfNIM);
        tfNIM.setBounds(200,30,200,20);
        add(lNama);
        lNama.setBounds(10,60,300,20);
        add(tfNama);
        tfNama.setBounds(200,60,200,20);
        add(lTTL);
        lTTL.setBounds(10,90,300,20);
        add(tfTTL);
        tfTTL.setBounds(200,90,200,20);
        add(lJenisKel);
        lJenisKel.setBounds(10,120,300,20);
        add(rbPria);
        rbPria.setBounds(200,120,100,20);
        add(rbWanita);
        rbWanita.setBounds(300,120,100,20);
        jk.add(rbPria);
        jk.add(rbWanita);
        add(lAgama);
        lAgama.setBounds(10,150,300,20);
        add(cmbAgama);
        cmbAgama.setBounds(200,150,200,20);
        add(lKelas);
        lKelas.setBounds(10,180,300,20);
        add(tfKelas);
        tfKelas.setBounds(200,180,200,20);
        add(lTanggal);
        lTanggal.setBounds(10,210,300,20);
        add(tfTanggal);
        tfTanggal.setBounds(200,210,200,20);
        add(lBerlaku);
        lBerlaku.setBounds(10,240,300,20);
        add(tfBerlaku);
        tfBerlaku.setBounds(200,240,200,20);
        add(btnRefresh);
        btnRefresh.setBounds(600,90,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(730,90,100,20);
        add(btnHapus);
        btnHapus.setBounds(600,150,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(730,150,100,20);
        add(scrollPane);
        scrollPane.setBounds(40,320,750,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setVisible(true);
    }
    
    public String getNIM(){
        return tfNIM.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
    public String getTTL(){
        return tfTTL.getText();
    }
    public String getJenisKel(){
        if (rbPria.isSelected()) 
           return rbPria.getText();
        else if (rbWanita.isSelected()) 
           return rbWanita.getText();
        else
            return null;
    }
    public String getAgama(){
        return cmbAgama.getSelectedItem().toString();
    }
    public String getKelas(){
        return tfKelas.getText();
    }
    public String getTanggal(){
        return tfTanggal.getText();
    }
    public String getBerlaku(){
        return tfBerlaku.getText();
    }
}
