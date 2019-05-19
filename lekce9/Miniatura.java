public class Miniatura {
    public static void main(String[] args) {
        
		awh.Image vstupniSoubor = awh.Image.loadFromFile(args[0]);
        int sirka = 300;
        int vyska = 150;
		String vystupniSoubor;
		boolean zdeformovat = false;
        
        if (args.length == 2) {
            vystupniSoubor = args[1];
        } else if (args.length == 3) {
            vystupniSoubor = args[2];
            String[] rozmery = args[1].split("x");
            if (rozmery.length != 2) {
                awh.Sys.die("Spatne zadane rozmery! Jako druhy argument zadejte rozmery ve tvaru VxS");
            }
            sirka = Integer.parseInt(rozmery[0]);
			if (rozmery[1].endsWith("!")) {
				zdeformovat = true;
				vyska = Integer.parseInt(rozmery[1].substring(0, (rozmery[1].length()-1)));
			} else {
				vyska = Integer.parseInt(rozmery[1]);
			}
        } else {
            awh.Sys.die("Spatne zadani! Spravne poradi argumentu je: vstup.jpg [VxS][!] vystup.jpg");
            return;
        }
            
		int sirkaVstupu = vstupniSoubor.getWidth();
        int vyskaVstupu = vstupniSoubor.getHeight();
		
		if (zdeformovat == false) {
			awh.Image obrazek = awh.Image.createEmpty(sirka, vyska, awh.Color.GRAY);
			
			// pokud je obrazek na vysku
			if ((vyskaVstupu / vyska) > (sirkaVstupu / sirka)) {	
				vstupniSoubor.rescale((sirkaVstupu * vyska / vyskaVstupu), vyska);
				obrazek.pasteFrom(vstupniSoubor, 0, 0);
			// pokud je obrazek na sirku
			} else {
				vstupniSoubor.rescale(sirka, (vyskaVstupu * sirka / sirkaVstupu));
				obrazek.pasteFrom(vstupniSoubor, 0, 0);
			}
			obrazek.saveToFile(vystupniSoubor);
		} else {
			vstupniSoubor.rescale(sirka, vyska);
			vstupniSoubor.saveToFile(vystupniSoubor);
		}        
    }
}