public class Vlnovka {

	public static void main(String[] args) {

		if (Integer.parseInt(args[0]) <= 1) {
			System.out.println("Spatne zadani! Velikost vlnovky musi byt vetsi nez 1.");
			System.exit(0);
		}

		int velikost = Integer.parseInt(args[0]);
		final int uvazovanaSirkaObrazovky = 80;

		for (int radek = 1; radek <= velikost; radek++) {
			for (int sloupec = 1; sloupec <= uvazovanaSirkaObrazovky; sloupec++) {
				if (casNaKanal(radek, sloupec, velikost)) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static boolean casNaKanal(int radek, int sloupec, int vyska) {
		boolean casNaKanal = false;
		// Kanal se v sikmicich ve smeru doprava dolu opakuje vzdy po
		// (2 * vyska - 2) znacich, pocinaje znakem ve sloupci (radek)
		if (sloupec % (2 * vyska - 2) == radek) {
			casNaKanal = true;
		}
		// Kanal se v sikmicich ve smeru doprava nahoru opakuje vzdy po
		// (2 * vyska - 2) znacich,
		// pocinaje znakem ve sloupci (2 * vyska - radek)
		if (sloupec % (2 * vyska - 2) == 2 * vyska - radek) {
			casNaKanal = true;
		}
		// Nasledujici if vypisuje kanal do mezer na druhem radku
		// v sikmicich ve smeru doprava nahoru
		if (sloupec % (2 * vyska - 2) == 0 && radek == 2) {
			casNaKanal = true;
		}
		return casNaKanal;
	}

}