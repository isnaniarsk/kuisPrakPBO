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
public class MVC {
        public void Anggota(){
            View_Anggota viewAnggota = new View_Anggota();
            Model_Kuis modelKuis = new Model_Kuis();
            Controller_Kuis controllerKuis = new Controller_Kuis(viewAnggota, modelKuis);
        }
    
        public void Buku(){
            View_Buku viewBuku = new View_Buku();
            Model_Kuis modelKuis = new Model_Kuis();
            Controller_Kuis controllerKuis = new Controller_Kuis(viewBuku, modelKuis);
        }
    
        public void Karyawan(){
            View_Karyawan viewKaryawan = new View_Karyawan();
            Model_Kuis modelKuis = new Model_Kuis();
            Controller_Kuis controllerKuis = new Controller_Kuis(viewKaryawan, modelKuis);
        }
    
        public void Peminjaman(){
            View_Peminjaman viewPeminjaman = new View_Peminjaman();
            Model_Kuis modelKuis = new Model_Kuis();
            Controller_Kuis controllerKuis = new Controller_Kuis(viewPeminjaman, modelKuis);
        }
}
