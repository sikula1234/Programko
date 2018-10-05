public class nasobilka {
    public static void main(String[] args) {
        
        for (int a = 1; a <= 10; a++) {
            for (int b = 1; b <= 10; b++) {
                if (a * b < 10) {
                    System.out.printf("%d  ", a * b);
                } else {
                    System.out.printf("%d ", a * b);
                }
            }
            System.out.println();
        }
        
    }                
}