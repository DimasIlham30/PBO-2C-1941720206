
public class DemoBuku {
    public static void main(String[] args) {
        Buku buku1 = new Buku();
        BukuCerpen buku2 = new BukuCerpen();
        
        buku1.setJudul("Sinar Pelangi");
        buku1.setJenis("Buku Tulis");
        buku1.setPencetak("Samid");
        buku1.setTahunCetak(1999);
        buku1.setJumlahBuku(10);
        buku1.tambahBuku(3);
        buku1.info();
        System.out.println("---------------------------");
        
        buku2.setJudul("Si Cicak");
        buku2.setJenis("Cerpen");
        buku2.setPencetak("MidGod");
        buku2.setTahunCetak(2000);
        buku2.setJumlahBuku(20);
        buku2.setKategori("Fiksi");
        buku2.setHalaman(100);
        buku2.info();
        System.out.println("---------------------------");
        
    }
    
}
