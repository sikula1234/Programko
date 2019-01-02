public class Pascal {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Spatne zadani! Tento program potrebuje jeden argument: "
					+ "pozadovany pocet radku vykreslovaneho trojuhelniku.");
			System.exit(0);
		}

		int pocetRadku = Integer.parseInt(args[0]);

		// Nasledujici postup prevzat z
		// https://cs.wikipedia.org/wiki/Pascal%C5%AFv_troj%C3%BAheln%C3%ADk

		// Vypis kombinacni cislo n nad k, kde n = poradi radku (od nuly)
		// a k = poradi cisla na radku (od nuly)
		for (int radek = 0; radek < pocetRadku; radek++) {
			opakujMezeru((pocetRadku - radek - 1) * 3);
			for (int poradiNaRadku = 0; poradiNaRadku <= radek; poradiNaRadku++) {
				System.out.printf("%-6d", kombinacniCislo(radek, poradiNaRadku));
			}
			System.out.printf("\n");
		}
	}

	public static void opakujMezeru(int kolikrat) {
		while (kolikrat > 0) {
			System.out.printf(" ");
			kolikrat--;
		}
	}

	public static long kombinacniCislo(int n, int k) {
		return (faktorial(n) / (faktorial(n - k) * faktorial(k)));
	}

	public static long faktorial(int x) {
		long vysledek = x;
		x--;
		while (x > 0) {
			vysledek *= x;
			x--;
		}
		return (vysledek == 0) ? 1 : vysledek;
	}
}