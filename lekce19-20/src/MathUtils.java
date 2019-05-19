public class MathUtils {
    public static int min(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int n : numbers) {
        	if (n < min) {
        		min = n;
        	}
        }
    	return min;
    }
    
    public static int gcd(int a, int b) {
    	int x = Math.abs(a);
    	int y = Math.abs(b);
    	while (y != 0) {
    		int r = x % y;
    		x = y;
    		y = r;
    	}
    	return x;
    }
}