public class maximum {
    public static void main(String[] args) {
        
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int nejvyssi = 0;
        
        while (scan.hasNextInt()) {
            int nove = scan.nextInt();
            if (nove > nejvyssi) {
              nejvyssi = nove;
            }
            
        }
        System.out.printf("Nejvyssi cislo ze zadanych je %d.\n", nejvyssi);
        
    }                
}