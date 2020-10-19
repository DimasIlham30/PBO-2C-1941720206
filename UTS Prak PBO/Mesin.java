public class Mesin {
    
    private String Merek;
    private double kecepatan;

    public Mesin(){

    }
    public void setMerek(String merekMesin){
        this.Merek = merekMesin;
    }
    public String getMerek(){
        return this.Merek;
    }
    public Double getKecepatan(){
        return this.Kecepatan;
    }
    public void tambahKecepatan(){
        kecepatan += 10;
    }
    public void kurangiKecepatan(){
        kecepatan -= 5;
    }

}
