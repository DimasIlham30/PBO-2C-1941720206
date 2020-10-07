public class Segitiga extends BangunDatar {
    
    float alas;
    float tinggi;
    float sisimiring;

    float luas(){
        float luas = (float)(alas * tinggi) / 2;
        System.out.println("Luas Segitiga : " + luas);
        return luas;
    }
    float keliling(){
        float keliling = (float)(alas + tinggi + sisimiring);
        System.out.println("Keliling Segitiga : " + keliling);
        return keliling;
    }
}
