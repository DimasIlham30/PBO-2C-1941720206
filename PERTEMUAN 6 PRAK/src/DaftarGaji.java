public class DaftarGaji {

    private Pegawai[] listPegawai;
    private int jumlahPegawaiSekarang = 0;

    public DaftarGaji(int jumlah_pegawai){
        listPegawai = new Pegawai[jumlah_pegawai];
    }
    public void addPegawai(Pegawai p){
        listPegawai[jumlahPegawaiSekarang] = p;
        jumlahPegawaiSekarang++;
    }
    public void printSemuaGaji(){
        for (int i = 0; i < jumlahPegawaiSekarang; i++) {
            System.out.println(listPegawai[i].getNama()+" mendapatkan gaji ");
            System.out.println(listPegawai[i].getGaji());
        }
    }
}
