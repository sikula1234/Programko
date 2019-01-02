// Kod castecne inspirovan vzorovym resenim podobne ulohy: https://alej.alisma.cz/prog1/pg08/index.html :)

public class Elipsa {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Spatne zadani! Tento program potrebuje dva argumenty: "
					+ "velikost horizontalni poloosy a velikost vertikalni poloosy.");
			System.exit(0);
		}

		int hlavniPoloosa = Integer.parseInt(args[0]);
		int vedlejsiPoloosa = Integer.parseInt(args[1]);

		// Pro kazdy souradnicovy bod [x,y] (postupne po radcich) zjisti,
		// zda lezi v elipse
		for (int y = -vedlejsiPoloosa; y <= vedlejsiPoloosa; y++) {
			for (int x = -hlavniPoloosa; x <= hlavniPoloosa; x++) {
				if (leziVElipse(x, y, hlavniPoloosa, vedlejsiPoloosa)) {
					// Pokud bod [x,y] lezi v elipse, vytiskni na nem "X"
					System.out.print("X");
				} else {
					// Pokud bod [x,y] nelezi v elipse, vytiskni na nem mezeru
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