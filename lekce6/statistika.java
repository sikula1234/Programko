public class statistika {
    public static void main(String[] args) {
        
        java.util.Scanner scan = new java.util.Scanner(System.in);
        double maximum = 0;
		double minimum = 0;
		double soucet = 0;
		double pocet = 0;
        
        while (scan.hasNextDouble()) {
            double nove = scan.nextDouble();
			if (pocet == 0) {
				maximum = nove;
				minimum = nove;
			}
            if (nove > maximum) {
              maximum = nove;
            }
			if (nove < minimum) {
              minimum = nove;
            }
			soucet += nove;
			pocet++;    
        }
        System.out.printf("Soucet: %.3f\n", soucet);
		System.out.printf("Minimum: %.3f\n", minimum);
		System.out.printf("Maximum: %.3f\n", maximum);
		System.out.printf("Aritmeticky prumer: %.3f\n", soucet / pocet);
        
    }                
}