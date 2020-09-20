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
public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota agg1 = new Anggota("Iwan", "Malang");
        
        System.out.println("Simpanan " + agg1.getNama() + " : Rp " + agg1.getSimpanan());
         
        agg1.setNama("Iwan");
        agg1.setAlamat("Malang");
        agg1.setor(1000000);
        
        System.out.println("Simpanan " + agg1.getNama() + " : Rp " + agg1.getSimpanan());
        
        agg1.pinjam(50000);
        System.out.println("Simpanan " + agg1.getNama() + " : Rp " + agg1.getSimpanan());
    }
}
