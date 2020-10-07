public class Lingkaran extends BangunDatar {
    
    float r;

    float luas(){
        float luas = (float)(3.14 * r * r);
        System.out.println("Luas Lingkaran : " + luas);
        return luas;
    }
    float keliling(){
        float keliling = (float)(2*3.14*r);
        System.out.println("Keliling Lingkaran : " + keliling);
        return keliling;
    }
}
