public class sude {
    public static void main(String[] args) {
    
        int a = Integer.parseInt(args[0]);
        
        if (a / 2 * 2 == a) {
            System.out.printf("Ano, cislo %d je vskutku sude.", a);
        } else {
            System.out.printf("Kdepak, cislo %d neni sude.", a);
        }
    
    }                
}