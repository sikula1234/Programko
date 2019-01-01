// Kod castecne inspirovan vzorovym resenim podobne ulohy: https://alej.alisma.cz/prog1/pg08/index.html :)

public class Elipsa {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Spatne zadani! Tento program potrebuje dva argumenty: "
					+ "velikost horizontalni poloosy a velikost vertikalni poloosy.");
			System.exit(0);
		}

		double a = Integer.parseInt(args[0]);
		double b = Integer.parseInt(args[1]);

		// Pro kazdy souradnicovy bod [x,y] (postupne po radcich) zjisti,
		// zda lezi v elipse
		for (double y = -b; y <= b; y++) {
			for (double x = -a; x <= a; x++) {
				// Pokud bod [x,y] lezi v elipse, vytiskni na nem "X"
				if (leziVElipse(x, y, a, b)) {
					System.out.print("X");
					// Pokud bod [x,y] nelezi v elipse, vytiskni na nem mezeru
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static boolean leziVElipse(double x, double y, double a, double b) {
		// Nasledujici vzorec prevzat z https://cs.wikipedia.org/wiki/Elipsa
		return ((x / a) * (x / a)) + ((y / b) * (y / b)) < 1;
	}
}