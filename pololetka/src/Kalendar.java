import java.text.SimpleDateFormat;
import java.util.Date;

public class Kalendar {

	public static void main(String[] args) {

		// Formatovani dnesniho data prevzato z
		// https://stackoverflow.com/questions/2942857/how-to-convert-current-date-into-string-in-java
		String dnesniDatum = new SimpleDateFormat("MMyyyy").format(new Date());
		int mesic = Integer.parseInt(dnesniDatum.substring(0, 2));
		int rok = Integer.parseInt(dnesniDatum.substring(2, 6));

		// Interpretace vstupu
		if (args.length > 2) {
			System.out.println("Spatne zadani! Zadejte nejvyse dva argumenty.");
		} else if (args.length == 1) {
			mesic = Integer.parseInt(args[0]);
		} else if (args.length == 2) {
			mesic = Integer.parseInt(args[0]);
			rok = Integer.parseInt(args[1]);
		}

		String[] nazvyMesicu = new String[] { "leden", "unor", "brezen", "duben", "kveten", "cerven", "cervenec",
				"srpen", "zari", "rijen", "listopad", "prosinec" };

		System.out.println("+----------------------+");
		System.out.printf("| ");

	}

}
