public class Odmocnina {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Spatne zadani! Tento program potrebuje dva argumenty: "
					+ "odmocnovane cislo a pozadovanou presnost (cim mensi, tim presnejsi bude vysledek).");
			System.exit(0);
		}

		double odmocnovaneCislo = Double.parseDouble(args[0]);
		double presnost = Double.parseDouble(args[1]);
		double predchoziOdhad = 1;
		double nejnovejsiOdhad = 2 + presnost;

		// Nasledujici postup (Newtonova metoda) prevzat z
		// https://en.wikipedia.org/wiki/Cube_root#Numerical_methods
		while (Math.abs(nejnovejsiOdhad - predchoziOdhad) >= presnost) {
			predchoziOdhad = nejnovejsiOdhad;
			nejnovejsiOdhad = ((odmocnovaneCislo / (predchoziOdhad * predchoziOdhad)) + (2 * predchoziOdhad)) / 3;
		}

		System.out.printf("%.10f\n", nejnovejsiOdhad);

	}
}