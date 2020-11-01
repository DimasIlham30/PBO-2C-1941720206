public class MainSegitiga {
    public static void main(String[] args) {
        Segitiga s = new Segitiga();
        Segitiga s2 = new Segitiga();
        Segitiga s3 = new Segitiga();
        Segitiga s4 = new Segitiga();
        System.out.println("======Sudut Pertama=======");
        s.totalSudut(40);
        s.infoSudut();
        System.out.println("======Sudut Kedua=========");
        s2.totalSudut(7, 5);
        s2.infoSudut();
        System.out.println("======Keliling Pertama=====");
        s3.keliling(6, 8,10);
        s3.infoSudut();
        System.out.println("======Keliling Kedua");
        s4.keliling(4, 7);
        s4.infoSudut();
    }
}
