/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author USER
 */
public class TestBackend {
    public static void main(String[] args) {
        JenisMobil jenmob = new JenisMobil("Mobil Keluarga", 1500000);
        JenisMobil jenmob1 = new JenisMobil("Mobil PickUp", 1000000);

        // test insert
        jenmob.save();
        jenmob1.save();

        // test update
        jenmob1.setHargaSewa(1200000);
        jenmob1.save();

        // test delete

        // test select all
        for (JenisMobil jen : new JenisMobil().getAll()) {
            System.out.println("Jenis : " + jen.getJenis() + ", Harga Sewa : " + jen.getHargaSewa());
        }

        // test search
        for (JenisMobil jen : new JenisMobil().search("Mobil_PickUp")) {
            System.out.println("Jenis : " + jen.getJenis() + ", Harga Sewa : " + jen.getHargaSewa());
        }
    }
}
