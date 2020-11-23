public class MediaInformasi implements Penerbit {
    
    public int jmlHalaman;
    private int tahunSekarang;

    public int getTahunSekarang(int tahun) {
        return tahunSekarang = tahun;
    }

    public void setJmlHalaman(int jmlHalaman) {
        this.jmlHalaman = jmlHalaman;
    }

    @Override
    public void reputasi() {
        System.out.println();
        
    }

    @Override
    public void alamatPenerbit(String alamat) {
        System.out.println();
        System.out.println("Alamat Penerbit: " + alamat);
        System.out.println();
    }

    @Override
    public void tahunBerdiri(int tahun) {
        System.out.println();
        int usia = tahunSekarang - tahun;
        System.out.println("Penerbit ini berdiri pada tahun: " + tahun + ", sehingga"
                + "penerbit ini sekarang berusia: " + usia + " tahun");
        System.out.println();
    }

}
