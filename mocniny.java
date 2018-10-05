public class mocniny {
    public static void main(String[] args) {
        
        int input = Integer.parseInt(args[0]);
        
        for (int x = 1; x * x <= input; x++) {
            System.out.printf("%d ", x * x);
                }
        
    }                
}