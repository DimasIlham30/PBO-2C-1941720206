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
public class TestBackendMobil {

    public static void main(String[] args) {
        JenisMobil Mobil_Keluarga = new JenisMobil().getById(7);
        JenisMobil Mobil_PickUp = new JenisMobil().getById(8);

        MobilKeluarga mk1 = new MobilKeluarga(Mobil_Keluarga, "S9134N", "Honda", "Merah", "Jazz");
        MobilKeluarga mk2 = new MobilKeluarga(Mobil_Keluarga, "S5432M", "Kijang", "Silver", "Innova");
        MobilKeluarga mk3 = new MobilKeluarga(Mobil_Keluarga, "S2415A", "Toyota", "Hitam", "Avanza");
// test insert
        mk1.save();
        mk2.save();
        mk3.save();
// test update
// test delete
        mk3.delete();
// test select all
        for (MobilKeluarga mk : new MobilKeluarga().getAll()) {
            System.out.println("Jenis        : " + mk.getJenis());
            System.out.println("No Polisi    : " + mk.getNopol());
            System.out.println("Merk         : " + mk.getMerkMobil());
            System.out.println("Nama         : " + mk.getNamaMobil());
            System.out.println("Warna        : " + mk.getWarnaMobil());
        }
// test search
        for (MobilKeluarga mk : new MobilKeluarga().search("Jazz")) {
            System.out.println("Jenis        : " + mk.getJenis());
            System.out.println("No Polisi    : " + mk.getNopol());
            System.out.println("Merk         : " + mk.getMerkMobil());
            System.out.println("Nama         : " + mk.getNamaMobil());
            System.out.println("Warna        : " + mk.getWarnaMobil());
        }
    }
}
