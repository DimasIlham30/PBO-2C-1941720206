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
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Kucing kucingKampung = new Kucing();
       Ikan lumbaLumba = new Ikan();
       Orang ani = new Orang("Ani");
       Orang budi = new Orang("Budi");
       ani.peliharaHewan(kucingKampung);
       budi.peliharaHewan(lumbaLumba);
       ani.ajakPeliharaanJalanJalan();
       budi.ajakPeliharaanJalanJalan();
    }
    
}
