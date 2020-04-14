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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class Controller_Kuis {
    View_Anggota viewAnggota;
    View_Buku viewBuku;
    View_Karyawan viewKaryawan;
    View_Peminjaman viewPeminjaman;
    Model_Kuis modelKuis;
    
    public Controller_Kuis(View_Anggota viewAnggota, Model_Kuis modelKuis){
        this.viewAnggota = viewAnggota;
        this.modelKuis = modelKuis;
        
        if(modelKuis.getBanyakAnggota()!=0){
            String dataAnggota[][] = modelKuis.readAnggota();
            viewAnggota.tabel.setModel((new JTable(dataAnggota, viewAnggota.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
        }
        viewAnggota.btnSimpan.addActionListener((ActionEvent e)-> {
            String jk = "";
            if(viewAnggota.getNIM().equals("")||viewAnggota.getNama().equals("")||viewAnggota.getTTL().equals("")||viewAnggota.getJenisKel().equals("")||viewAnggota.getAgama().equals("")||viewAnggota.getKelas().equals("")||viewAnggota.getTanggal().equals("")||viewAnggota.getBerlaku().equals("")){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            }
            else{
                
                if(viewAnggota.rbPria.isSelected()){
                    jk = "Laki-laki";
                }
                else{
                    jk = "Perempaun";
                }
                
                String nim = viewAnggota.getNIM();
                String nama = viewAnggota.getNama();
                String ttl = viewAnggota.getTTL();
                String agama = viewAnggota.getAgama();
                String kelas = viewAnggota.getKelas();
                String tanggal = viewAnggota.getTanggal();
                String berlaku = viewAnggota.getBerlaku();
                modelKuis.insertAnggota(nim, nama, ttl, jk, agama, kelas, tanggal, berlaku);
                viewAnggota.tfNIM.setText("");
                viewAnggota.tfNama.setText("");
                viewAnggota.tfTTL.setText("");
                viewAnggota.cmbAgama.setSelectedItem("");
                viewAnggota.tfKelas.setText("");
                viewAnggota.tfTanggal.setText("");
                viewAnggota.tfBerlaku.setText("");
                
                String dataAnggota[][] = modelKuis.readAnggota();
                viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
                
            }
        });
        viewAnggota.btnRefresh.addActionListener((ActionEvent e) -> {
            viewAnggota.tfNIM.setText("");
            viewAnggota.tfNama.setText("");
            viewAnggota.tfTTL.setText("");
            viewAnggota.rbPria.setText("");
            viewAnggota.rbWanita.setText("");
            viewAnggota.cmbAgama.setSelectedItem("");
            viewAnggota.tfKelas.setText("");
            viewAnggota.tfTanggal.setText("");
            viewAnggota.tfBerlaku.setText("");
        });
        viewAnggota.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewAnggota.tabel.getSelectedRow();
                int kolom = viewAnggota.tabel.getSelectedColumn();
                String dataterpilih = viewAnggota.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIM "+dataterpilih+ "?"," Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelKuis.deleteAnggota(dataterpilih);
                    String dataAnggota[][] = modelKuis.readAnggota();
                    viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
        viewAnggota.btnKeluar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Menu menu = new Menu();
        }
        });
    }
    
    public Controller_Kuis(View_Buku viewBuku, Model_Kuis modelKuis){
        
        this.viewBuku = viewBuku;
        this.modelKuis = modelKuis;
        if(modelKuis.getBanyakBuku()!=0){
            String dataBuku[][] = modelKuis.readBuku();
            viewBuku.tabel.setModel((new JTable(dataBuku, viewBuku.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
        }
        viewBuku.btnSimpan.addActionListener((ActionEvent e)-> {
            if(viewBuku.getKode().equals("")||viewBuku.getJudul().equals("")||viewBuku.getPengarang().equals("")||viewBuku.getPenerbit().equals("")||viewBuku.getTahun().equals("")){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            }
            else{
                String kode = viewBuku.getKode();
                String judul = viewBuku.getJudul();
                String pengarang = viewBuku.getPengarang();
                String penerbit = viewBuku.getPenerbit();
                String tahun = viewBuku.getTahun();
                modelKuis.insertBuku(kode, judul, pengarang, penerbit, tahun);
                viewBuku.tfKode.setText("");
                viewBuku.tfJudul.setText("");
                viewBuku.tfPengarang.setText("");
                viewBuku.tfPenerbit.setText("");
                viewBuku.tfTahun.setText("");
                String dataBuku[][] = modelKuis.readBuku();
                viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
                
            }
        });
        viewBuku.btnRefresh.addActionListener((ActionEvent e) -> {
            viewBuku.tfKode.setText("");
            viewBuku.tfJudul.setText("");
            viewBuku.tfPengarang.setText("");
            viewBuku.tfPenerbit.setText("");
            viewBuku.tfTahun.setText("");
        });
        viewBuku.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewBuku.tabel.getSelectedRow();
                int kolom = viewBuku.tabel.getSelectedColumn();
                String dataterpilih = viewBuku.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus Kode "+dataterpilih+ "?"," Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelKuis.deleteBuku(dataterpilih);
                    String dataBuku[][] = modelKuis.readBuku();
                    viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
        viewBuku.btnKeluar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
            }
        });
        
    }
    
    public Controller_Kuis(View_Karyawan viewKaryawan, Model_Kuis modelKuis){
        
        this.viewKaryawan = viewKaryawan;
        this.modelKuis = modelKuis;
        if(modelKuis.getBanyakKaryawan()!=0){
            String dataKaryawan[][] = modelKuis.readKaryawan();
            viewKaryawan.tabel.setModel((new JTable(dataKaryawan, viewKaryawan.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
        }
        viewKaryawan.btnSimpan.addActionListener((ActionEvent e)-> {
            String jeniskelamin = "";
            if(viewKaryawan.getNIK().equals("")||viewKaryawan.getNamaKar().equals("")||viewKaryawan.getJenisKel().equals("")||viewKaryawan.getGolongan().equals("")||viewKaryawan.getJabatan().equals("")||viewKaryawan.getTunjangan().equals("")||viewKaryawan.getGaji().equals("")){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            }
            else{
                if(viewKaryawan.rbPria.isSelected()){
                    jeniskelamin = "Laki-laki";
                }
                else{
                    jeniskelamin = "Perempaun";
                }
                String nik = viewKaryawan.getNIK();
                String namakar = viewKaryawan.getNamaKar();
                String golongan = viewKaryawan.getGolongan();
                String jabatan = viewKaryawan.getJabatan();
                String tunjangan = viewKaryawan.getTunjangan();
                String gaji = viewKaryawan.getGaji();
                modelKuis.insertKaryawan(nik, namakar, jeniskelamin, golongan, jabatan, tunjangan, gaji);
                viewKaryawan.tfNIK.setText("");
                viewKaryawan.tfNamaKar.setText("");
                viewKaryawan.rbPria.setText("");
                viewKaryawan.rbWanita.setText("");
                viewKaryawan.tfGol.setText("");
                viewKaryawan.tfTunjangan.setText("");
                viewKaryawan.tfGaji.setText("");
                String dataKaryawan[][] = modelKuis.readKaryawan();
                viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
                
            }
        });
        viewKaryawan.btnRefresh.addActionListener((ActionEvent e) -> {
            viewKaryawan.tfNIK.setText("");
            viewKaryawan.tfNamaKar.setText("");
            viewKaryawan.rbPria.setText("");
            viewKaryawan.rbWanita.setText("");
            viewKaryawan.tfGol.setText("");
            viewKaryawan.tfTunjangan.setText("");
            viewKaryawan.tfGaji.setText("");
        });
        viewKaryawan.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewKaryawan.tabel.getSelectedRow();
                int kolom = viewKaryawan.tabel.getSelectedColumn();
                String dataterpilih = viewKaryawan.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIK "+dataterpilih+ "?"," Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelKuis.deleteKaryawan(dataterpilih);
                    String dataKaryawan[][] = modelKuis.readKaryawan();
                    viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
        viewKaryawan.btnKeluar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
            }
        });
    }
    
    
    public Controller_Kuis(View_Peminjaman viewPeminjaman, Model_Kuis modelKuis){
        
        this.viewPeminjaman = viewPeminjaman;
        this.modelKuis = modelKuis;
        if(modelKuis.getBanyakPeminjaman()!=0){
            String dataPeminjaman[][] = modelKuis.readPeminjaman();
            viewPeminjaman.tabel.setModel((new JTable(dataPeminjaman, viewPeminjaman.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
        }
        
        viewPeminjaman.btnSimpan.addActionListener((ActionEvent e)-> {
            if(viewPeminjaman.getNo().equals("")||viewPeminjaman.getNama().equals("")||viewPeminjaman.getKelas().equals("")||viewPeminjaman.getKode().equals("")||viewPeminjaman.getJudul().equals("")||viewPeminjaman.getPenerbit().equals("")||viewPeminjaman.getTglPinjam().equals("")||viewPeminjaman.getTglKembali().equals("")||viewPeminjaman.getLama().equals("")||viewPeminjaman.getDenda().equals("")||viewPeminjaman.getNIK().equals("")||viewPeminjaman.getPetugas().equals("")){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            }
            else{
                String nomor = viewPeminjaman.getNo();
                String NIM = viewPeminjaman.getNIM();
                String nama = viewPeminjaman.getNama();
                String kelas = viewPeminjaman.getKelas();
                String kode = viewPeminjaman.getKode();
                String judul = viewPeminjaman.getJudul();
                String penerbit = viewPeminjaman.getPenerbit();
                String tgl_pinjam = viewPeminjaman.getTglPinjam();
                String tgl_kembali = viewPeminjaman.getTglKembali();
                String lama_pinjam = viewPeminjaman.getLama();
                String denda = viewPeminjaman.getDenda();
                String NIK = viewPeminjaman.getNIK();
                String namakar = viewPeminjaman.getPetugas();
                modelKuis.insertPeminjaman(nomor, NIM, nama, kelas, kode, judul, penerbit, tgl_pinjam, tgl_kembali, lama_pinjam, denda, NIK, namakar);
                viewPeminjaman.tfNo.setText("");
                viewPeminjaman.tfNIM.setText("");
                viewPeminjaman.tfNama.setText("");
                viewPeminjaman.tfKelas.setText("");
                viewPeminjaman.tfKode.setText("");
                viewPeminjaman.tfKode.setText("");
                viewPeminjaman.tfJudul.setText("");
                viewPeminjaman.tfPenerbit.setText("");
                viewPeminjaman.tfTglPinjam.setText("");
                viewPeminjaman.tfTglKembali.setText("");
                viewPeminjaman.tfLama.setText("");
                viewPeminjaman.tfDenda.setText("");
                viewPeminjaman.tfNIK.setText("");
                viewPeminjaman.tfNamaKar.setText("");
                String dataPeminjaman[][] = modelKuis.readPeminjaman();
                viewPeminjaman.tabel.setModel((new JTable(dataPeminjaman, viewPeminjaman.namaKolom)).getModel());
            }
        });
            viewPeminjaman.btnRefresh.addActionListener((ActionEvent e) -> {
                viewPeminjaman.tfNo.setText("");
                viewPeminjaman.tfNIM.setText("");
                viewPeminjaman.tfNama.setText("");
                viewPeminjaman.tfKelas.setText("");
                viewPeminjaman.tfKode.setText("");
                viewPeminjaman.tfKode.setText("");
                viewPeminjaman.tfJudul.setText("");
                viewPeminjaman.tfPenerbit.setText("");
                viewPeminjaman.tfTglPinjam.setText("");
                viewPeminjaman.tfTglKembali.setText("");
                viewPeminjaman.tfLama.setText("");
                viewPeminjaman.tfDenda.setText("");
                viewPeminjaman.tfNIK.setText("");
                viewPeminjaman.tfNamaKar.setText("");
        });
        viewPeminjaman.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewPeminjaman.tabel.getSelectedRow();
                int kolom = viewPeminjaman.tabel.getSelectedColumn();
                String dataterpilih = viewPeminjaman.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus Nomor Peminjaman "+dataterpilih+ "?"," Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelKuis.deletePeminjaman(dataterpilih);
                    String dataPeminjaman[][] = modelKuis.readPeminjaman();
                    viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
        viewPeminjaman.btnKeluar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
            }
        });
    }
}

    