public class MainTugas {
        public static void main(String[] args) {        
            Singa s = new Singa("Si Singa", 4, "Roarr", "Orange Belang-Belang");
            Keledai k = new Keledai("Si Keledai", 4, "Xixi", "Abu - Abu");
            Gorilla g = new Gorilla("Si Gorilla", 2, "Huaaa", "Hitam");
            
            s.displayMakan();
            s.displayBinatang();
            s.displayData();
            System.out.println("===============================================");
            k.displayMakan();
            k.displayBinatang();
            k.displayData();
            System.out.println("===============================================");
            g.displayMakan();
            g.displayBinatang();
            g.displayData();
            System.out.println("===============================================");
    }    
}
