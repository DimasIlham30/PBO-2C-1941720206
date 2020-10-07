public class MainBangun {
    
    public static void main(String[] args) {
        PersegiPanjang p = new PersegiPanjang();
        Lingkaran l = new Lingkaran();
        Segitiga s = new Segitiga();

        p.lebar= 3;
        p.panjang= 5;

        l.r= 7;

        s.alas= 6;
        s.tinggi=8;
        s.sisimiring=10;

        p.luas();
        p.keliling();
        l.luas();
        l.keliling();
        s.luas();
        s.keliling();
    }
}
