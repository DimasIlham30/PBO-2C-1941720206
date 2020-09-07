
public class Buku {
    private String pencetak, jenisBuku, judulBuku;
    private int tahunCetak, jumlahBuku;
    
    public void setJudul(String newValue){
        judulBuku = newValue;
    }
    public void setJenis(String newValue){
        jenisBuku = newValue;
    }
    public void setPencetak(String newValue){
        pencetak = newValue;
    }
    public void setTahunCetak(int newValue){
        tahunCetak = newValue;
    }
    public void setJumlahBuku(int newValue){
        jumlahBuku = newValue;
    }
    public int tambahBuku(int newValue){
        jumlahBuku += newValue;
        return jumlahBuku;
    }
    public void info(){
        System.out.println("\n----------------------------");
        System.out.println("Judul Buku\t\t: " + judulBuku);
        System.out.println("Jenis Buku\t\t: " + jenisBuku);
        System.out.println("Pencetak\t\t: " + pencetak);
        System.out.println("Tahun Cetak\t\t: " + tahunCetak);
        System.out.println("Jumlah Buku\t\t: " + jumlahBuku );
    }
}
