public class Pi {
	public static void main(String[] args) {

		final double boduCelkem = 10000000; // Tento pocet generovanych bodu urcuje presnost vypoctu pi
		double boduVKruhu = 0;

		for (int i = 0; i < boduCelkem; i++) {
			double x = Math.random();
			double y = Math.random();
			if (jeVKruhu(x, y)) {
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
	// (souradnice x = 0.5, y = 0.5) mensi nez delka polomeru kruhu
	// (r = 0.5). Tato uvaha je zde vystizena Pythagorovou vetou.
	public static boolean jeVKruhu(double x, double y) {
		return (Math.pow(Math.abs(0.5 - x), 2) + Math.pow(Math.abs(0.5 - y), 2) < Math.pow(0.5, 2));
	}
}