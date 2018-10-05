public class trojuhelnik2 {
    public static void main(String[] args) {
        
        for (int radek = 1; radek <= 5; radek++) {
            
            for (int znak = 1; znak <= 5 - radek; znak++) {
                System.out.printf(" ");
            }
            
            for (int znak = 1; znak <= radek; znak++) {
                System.out.printf("X");
            }
            
            System.out.println();
            
        }
        
    }                
}