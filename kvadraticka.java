public class kvadraticka {
    public static void main(String[] args) {
        
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        
        if (((b*b)-(4*a*c)) < 0) {
			System.out.println("Rovnice nema reseni, ponevadz diskriminant je mensi nez 0.");
        } else {
			double x = (((0 - b) + Math.sqrt((b * b)-(4 * a * c))) / (2 * a));
			double y = (((0 - b) - Math.sqrt((b * b)-(4 * a * c))) / (2 * a));
			if (((b*b)-(4*a*c)) == 0) {
				System.out.printf("x = %.3f", x);
			} else {
				System.out.printf("x1 = %.3f; x2 = %.3f", x, y);
			}
			
        }
        
    }                
}