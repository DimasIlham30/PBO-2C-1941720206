/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbominggu10.abstractclass;

/**
 *
 * @author DIMAS
 */
public class Orang {
    private String nama;
    private Hewan hewanPeliharan;
    
    public Orang(String nama){
        this.nama = nama;
    }
    public void peliharaHewan(Hewan hewanPeliharaan){
        this.hewanPeliharan = hewanPeliharaan;
    }
    public void ajakPeliharaanJalanJalan(){
        System.out.println("Namaku "+ this.nama);
        System.out.println("Hewan peliharaanku berjalan dengan cara: ");
        this.hewanPeliharan.bergerak();
        System.out.println("--------------------------------");
    }
}
