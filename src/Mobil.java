
public class Mobil {
    private String merek, platNomor, warna;
    private int no_mesin;
    
    public void setMerek(String newValue){
        merek = newValue;
    }
    public void platNomor(String newValue){
        platNomor = newValue;
    }
    public void setWarna(String newValue){
        warna = newValue;
    }
    public void no_mesin(int newValue){
        no_mesin = newValue;
    }
    public void cetakStatus(){
        System.out.println("Merek: " + merek);
        System.out.println("platNomor: " + platNomor);
        System.out.println("Warna: " + warna);
        System.out.println("no_mesin: " + no_mesin);
    }
}
