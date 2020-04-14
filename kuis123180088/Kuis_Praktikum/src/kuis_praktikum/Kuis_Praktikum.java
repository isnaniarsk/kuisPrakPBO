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
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Kuis_Praktikum {
    public static void main(String[] args) {
       Menu menu = new Menu();
    }
       
}

class Menu extends JFrame{
    JLabel lTitle = new JLabel("MENU UTAMA");
    JButton btnAnggota = new JButton("INPUT ANGGOTA");
    JButton btnBuku = new JButton("INPUT DATA BUKU");
    JButton btnKaryawan = new JButton("INPUT KARYAWAN");
    JButton btnPeminjaman = new JButton("DATA PEMINJAMAN");
    
    Menu(){
        setTitle("MENU UTAMA");
	setSize(550,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        
        add(lTitle);
        lTitle.setBounds(215,20,140,20);
        add(btnAnggota);
        btnAnggota.setBounds(60,60,180,60);
        add(btnBuku);
        btnBuku.setBounds(280,60,180,60);
        add(btnKaryawan);
        btnKaryawan.setBounds(60,150,180,60);
        add(btnPeminjaman);
        btnPeminjaman.setBounds(280,150,180,60);
        setVisible(true);
        
        btnAnggota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MVC mvc = new MVC();
                mvc.Anggota();
            }
        });
        
        btnBuku.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MVC mvc = new MVC();
                mvc.Buku();
            }
        });
        
        btnKaryawan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MVC mvc = new MVC();
                mvc.Karyawan();
            }
        });
        
        btnPeminjaman.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MVC mvc = new MVC();
                mvc.Peminjaman();
            }
        });
}
}
