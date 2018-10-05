public class nasobky {
    public static void main(String[] args) {
        
        for (int x = 3; x <= 30;) {
            for  (int poradivradku = 1; poradivradku <= 4; poradivradku++, x = x + 3) {
                if (x <= 30) {System.out.printf("%d ", x);}  
            }
            System.out.println();
        }
        
    }                
}