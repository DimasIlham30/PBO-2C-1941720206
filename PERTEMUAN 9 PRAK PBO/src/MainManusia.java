public class MainManusia {
    public static void main(String[] args) {
        Manusia a = new Manusia();
        Dosen b = new Dosen();
        Mahasiswa c = new Mahasiswa(); 
        System.out.println("======MANUSIA======");
        a.makan();
        a.bernafas();
        System.out.println("======DOSEN========");
        a = b;
        a.makan();
        b.lembur();
        System.out.println("======MAHASISWA====");
        a = c;
        a.makan();
        c.tidur();
    }
}
