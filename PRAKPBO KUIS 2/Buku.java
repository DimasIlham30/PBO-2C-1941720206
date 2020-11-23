public class Buku extends MediaInformasi {
   
    @Override
    public void setJmlHalaman(int jmlHalaman) {
        super.setJmlHalaman(jmlHalaman);
        System.out.println("Buku ini memiliki: "+jmlHalaman+" halaman");
        System.out.println("Jika dihitung dengan covernya, maka jumlah halaman dari"
                + " buku tersebut: " + (jmlHalaman + 4) + " halaman, lebih tebal daripada"
                        + " majalah karena terdapat cover dalam dan cover luar");
    }

    @Override
    public void reputasi() {
        super.reputasi(); 
        System.out.println("Penerbit Buku ini bereputasi!");
    }

}
