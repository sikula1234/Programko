public class Seq {
	public static void main(String[] args) {

		int zacatek = 1;
		int konec = 10;
		int krok = 1;
		int posunArgumentu = 0;
		String oddelovac = new String(" ");

		if (args.length >= 1 && args[0].equals("-s")) {
			oddelovac = args[1];
			// Pokud je pozadovan oddelovac,
			// vsechny nasledujici argumenty jsou posunuty o 2 mista dal
			posunArgumentu = 2;
		}

		// Interpretace zadanych argumentu
		switch (args.length - posunArgumentu) {
		case 1:
			konec = Integer.parseInt(args[0 + posunArgumentu]);
			break;
		case 2:
			zacatek = Integer.parseInt(args[0 + posunArgumentu]);
			konec = Integer.parseInt(args[1 + posunArgumentu]);
			break;
		case 3:
			zacatek = Integer.parseInt(args[0 + posunArgumentu]);
			krok = Integer.parseInt(args[1 + posunArgumentu]);
			konec = Integer.parseInt(args[2 + posunArgumentu]);
			break;
		default:
			System.out.println("Spatne zadani! Instrukce pro spravne zadani najdete na "
					+ "https://alej.alisma.cz/prog1/zp/seq.html");
			System.exit(0);
		}

		// Rozhodni, jestli je rada rostouci nebo klesajici,
		// a podle toho spust cyklus vypisovani cisel
		if (krok >= 1) {
			for (int i = zacatek; i <= konec; i += krok) {
				rozhodniJestliVypsatOddelovac(i, zacatek, oddelovac);
			}
		} else if (krok <= -1) {
			for (int i = zacatek; i >= konec; i += krok) {
				rozhodniJestliVypsatOddelovac(i, zacatek, oddelovac);
			}
		} else {
			System.out.println("Spatne zadani! Krok (prostredni ze tri ciselnych argumentu) nesmi byt roven 0.");
		}

	}

	public static void rozhodniJestliVypsatOddelovac(int i, int zacatek, String oddelovac) {
		if (i == zacatek) {
			System.out.printf("%d", i);
		} else {
			System.out.printf("%s%d", oddelovac, i);
		}
	}
}