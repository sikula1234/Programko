public class Odmocnina {
    public static void main(String[] args) {
        
		double S = Double.parseDouble(args[0]);
		double presnost = Double.parseDouble(args[1]);
		double x1 = 1;
		double x2 = 2 + presnost;
		
		while (Math.abs(x2 - x1) >= presnost) {
			x1 = x2;
			x2 = (x1 + (S / x1)) / 2;
		}
		
		System.out.printf("%.10f\n", x2);
	
	}
}