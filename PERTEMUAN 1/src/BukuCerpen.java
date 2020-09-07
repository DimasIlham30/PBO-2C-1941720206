public class BukuCerpen extends Buku {
    private int halaman;
    private String kategori;
    
    public void setKategori(String newValue){
        kategori = newValue;
    }
    public void setHalaman(int newValue){
        halaman = newValue;
    }
    public int tambahHalaman(int newValue){
        halaman += newValue;
        return halaman;
    }
    public int kurangHalaman(int newValue){
        halaman -= newValue;
        return halaman;
    }
    public void info(){
        super.info();
        System.out.println("Kategori\t\t: " + kategori);
        System.out.println("Halaman\t\t: " + halaman);
    }
}
