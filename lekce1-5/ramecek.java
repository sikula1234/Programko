public class ramecek {
    public static void main(String[] args) {
        
        int vnitrnisirka = 20;
        int vnitrnivyska = 3;
       
        for (int radek = 1; radek <= 2; radek++) {
            for (int poradivradku = 1; poradivradku <= vnitrnisirka + 4; poradivradku++) {
                System.out.printf("X");
            }
            System.out.println();
        }
       
        for (int radek = 3; radek <= vnitrnivyska + 2; radek++) {
            for (int poradivradku = 1; poradivradku <= 2; poradivradku++) {
                System.out.printf("X");
            }
            for (int poradivradku = 3; poradivradku <= vnitrnisirka + 2; poradivradku++) {
                System.out.printf(" ");
            }
            for (int poradivradku = vnitrnisirka + 3; poradivradku <= vnitrnisirka + 4; poradivradku++) {
                System.out.printf("X");
            }
            System.out.println();
        }
        
        for (int radek = 1; radek <= 2; radek++) {
            for (int poradivradku = 1; poradivradku <= vnitrnisirka + 4; poradivradku++) {
                System.out.printf("X");
            }
            System.out.println();
        }
        
    }                
}