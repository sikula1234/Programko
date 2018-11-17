public class KombinacniCislo {
    public static void main(String[] args) {
        
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		
		if (n < k) {
			System.out.print("Chyba: Cislo n (prvni argument) musi byt vetsi nez cislo k (druhy argument).\n");
		} else {
			if (n >= 0 || k >= 0 || n > 20 || k > 20) {
				System.out.print("Chyba: Zadana cisla musi byt kladna a zaroven mensi nebo rovna 20.\n");
			} else {
				System.out.printf("%d\n", (faktorial(n) / (faktorial(n - k) * faktorial(k))));
			}
		}
	
	}
	
	public static long faktorial(int x) {
		long vysledek = x;
		x--;
		while (x > 0) {
			vysledek *= x;
			x--;
		}
		return vysledek;
	}
}