public class Pi {
	public static void main(String[] args) {

		final double boduCelkem = 10000000; // Tento pocet generovanych bodu urcuje presnost vypoctu pi
		double boduVKruhu = 0;

		for (int i = 0; i < boduCelkem; i++) {
			// Vygeneruj bod s nahodnou x-ovou a y-ovou vzdalenosti
			// od stredu kruhu (jez ma souradnice x = 0.5, y = 0.5)
			if (jeVKruhu(0.5 - Math.random(), 0.5 - Math.random())) {
				boduVKruhu++;
			}
		}

		// Kruh vepsany ctverci ma obsah Skruhu = pi*r^2, takze pi = Skruhu/r^2
		// Zmineny ctverec ma obsah Sctverce = (2r)^2 = 4*r^2, takze r^2 = Sctverce/4
		// Dosazenim druhe rovnice do prvni ziskame:
		// pi = Skruhu/(Sctverce/4) = Skruhu/Sctverce*4
		double odhadPi = boduVKruhu / boduCelkem * 4;
		System.out.printf("%f", odhadPi);

	}

	// Bod lezi v kruhu, pokud je vzdalenost bodu od stredu kruhu
	// (vygenerovana volanim funkce jeVKruhu vyse)
	// mensi nez delka polomeru kruhu (r = 0.5).
	// Tato uvaha je zde vystizena Pythagorovou vetou.
	public static boolean jeVKruhu(double x, double y) {
		return x * x + y * y < 0.25;
	}
}