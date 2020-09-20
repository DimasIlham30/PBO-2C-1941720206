/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KoperasiGetterSetter;

/**
 *
 * @author user
 */
public class TestKoperasi {
    public static void main(String[] args) {
        Anggota agg = new Anggota("111222333444", "Donny", 10000000);
        
        System.out.println("Nama Anggota : " + agg.nama);
        System.out.println("Limit Pinjaman : Rp " + agg.limited);
        
        System.out.println("Meminjam Uang Rp 15000000");
        agg.pinjaman(15000000);
        
        System.out.println("Meminjam Uang Rp 5000000");
        agg.pinjaman(5000000);
        System.out.println("Jumlah Pinjaman Saat Ini : Rp " + agg.jumlahPinjaman());
        
        System.out.println("Membayar Angsuran : Rp 1000000");
        agg.angsuran(1000000);
        System.out.println("Jumlah Pinjaman Saat Ini : Rp " + agg.jumlahPinjaman());
        
        System.out.println("Membayar Angsuran : Rp 3000000");
        agg.angsuran(3000000);
        System.out.println("Jumlah Pinjaman Saat Ini : Rp " + agg.jumlahPinjaman());
        
        System.out.println("Meminjam Uang Rp 5000000");
        agg.pinjaman(5000000);
        System.out.println("Jumlah Pinjaman Saat Ini : Rp " + agg.jumlahPinjaman());
        
        System.out.println("Membayar Angsuran : Rp 6000000");
        agg.angsuran(6000000);
        System.out.println("Jumlah Pinjaman Saat Ini : Rp " + agg.jumlahPinjaman());
        
    }
}
