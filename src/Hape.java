
public class Hape {
    private String merek, warna;
    private int harga, jumlahHape;
    
    public void setMerek(String newValue){
        merek = newValue;
    }
    public void setWarna(String newValue){
        warna = newValue;
    }
    public void setHarga(int newValue){
        harga = newValue;
    }
    public void setJumlahHape(int newValue){
        jumlahHape = newValue;
    }
    public void info(){
        System.out.println("--------------------------");
        System.out.println("Merek Hape: " + merek);
        System.out.println("Warna Hape: " + warna);
        System.out.println("Harga Hape: " + harga);
        System.out.println("Jumlah Hape : " + jumlahHape);
        System.out.println("--------------------------");
    }
}
