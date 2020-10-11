public class MainGaji {
    
    public static void main(String[] args) {
        Dosen d1 = new Dosen();
        d1.setNama("Iyok");
        d1.setSKS(10);

        Pegawai p1 = new Pegawai();
        p1.setNama("Faros");

        DaftarGaji daftar_gaji = new DaftarGaji(2);
        daftar_gaji.addPegawai(d1);
        daftar_gaji.addPegawai(p1);
        daftar_gaji.printSemuaGaji();
    }
}
