public class delitele {
    public static void main(String[] args) {
        
        int x = Integer.parseInt(args[0]);
        
        for (int delitel = 1; delitel <= x; delitel++) {
            int zbytek = x % delitel;
            if (zbytek == 0) {System.out.printf("%d ", delitel);};
        }
        
    }                
}