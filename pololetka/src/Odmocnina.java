public class Odmocnina {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Spatne zadani! Tento program potrebuje dva argumenty: "
					+ "odmocnovane cislo a pozadovanou presnost (cim mensi, tim presnejsi bude vysledek).");
			System.exit(0);
		}

		double S = Double.parseDouble(args[0]);
		double presnost = Double.parseDouble(args[1]);
		double x1 = 1;
		double x2 = 2 + presnost;

		// Nasledujici postup (Newtonova metoda) prevzat z
		// https://en.wikipedia.org/wiki/Cube_root#Numerical_methods
		while (Math.abs(x2 - x1) >= presnost) {
			x1 = x2;
			x2 = ((S / (x1 * x1)) + (2 * x1)) / 3;
		}

		System.out.printf("%.10f\n", x2);

	}
}