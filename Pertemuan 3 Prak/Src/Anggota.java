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
public class Anggota {

    public String nama;
    public String ktp;
    public double simpanan;
    public int limited;
    private double pinjam1;

    Anggota(String ktp, String nama, int limit) {
        this.nama = nama;
        this.ktp = ktp;
        this.simpanan = 0;
        this.limited = limit;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNama() {
        return nama;
    }

    public String getKtp() {
        return ktp;
    }

    public double getSimpanan() {
        return simpanan;
    }

    public void setor(double uang) {
        simpanan += uang;
    }

    public void pinjam(double uang) {
        simpanan -= uang;
    }
    
    public int getLimit(){
        return limited;
    }

    public void pinjaman(double uang){
        if (uang > limited) {
            System.out.println("Maaf Pinjaman Melebihi Limit!!!");
        } else {
            pinjam1 += uang;
            System.out.println("Pinjaman : Rp " + pinjam1);
            System.out.println("Pinjaman Berhasil!!!");
        }
    }
    public double jumlahPinjaman() {
        return pinjam1;
    }
    
    public void angsuran(double uang){
        pinjam1 -= uang;
    }
}
