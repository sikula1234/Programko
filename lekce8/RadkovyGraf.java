public class RadkovyGraf {
    public static void main(String[] args) {
        
		awh.IntList cisla = awh.IntList.create();
		java.util.Scanner vstup = new java.util.Scanner(System.in);
		while (vstup.hasNext()) {
			cisla.add(vstup.nextInt());
		}
		
		int nejvetsiCislo = 0;
		for (int i = 0; i < cisla.size(); i++) {
			if (cisla.get(i) > nejvetsiCislo) {
				nejvetsiCislo = cisla.get(i);
			}
		}
		
		if (nejvetsiCislo > 60) {
			for (int j = 0; j < cisla.size(); j++) {
				opakujKanal(cisla.get(j) * 60 / nejvetsiCislo);
				System.out.print("\n");
			}
		} else {
			for (int j = 0; j < cisla.size(); j++) {
				opakujKanal(cisla.get(j));
				System.out.print("\n");
			}
		}
	
	}
	
	public static void opakujKanal(int kolikrat) {
    while (kolikrat > 0) {
        System.out.printf("#");
        kolikrat--;
    }
}
}