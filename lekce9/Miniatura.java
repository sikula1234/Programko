public class Miniatura {
    public static void main(String[] args) {
        
        String vstupniSoubor;
        int sirka = 300;
        int vyska = 150;
        String vystupniSoubor;
        
        if (args.length == 2) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[1];
        } else if (args.length == 3) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[2];
            String[] rozmery = args[1].split("x");
            if (rozmery.length != 2) {
                awh.Sys.die("Spatne zadane rozmery (%s).", args[1]);
            }
            sirka = Integer.parseInt(rozmery[0]);
            vyska = Integer.parseInt(rozmery[1]);
        } else {
            awh.Sys.die("Pouziti: vstup.jpg [VxS] vystup.jpg");
            // Bez returnu si bude prekladac stezovat
            return;
        }
        
            
		    int sirkaVstupu = vstupniSoubor.getWidth();
        int vyskaVstupu = vstupniSoubor.getHeight();
		
		    awh.Image vystupniSoubor = awh.Image.createEmpty(150, 100, awh.Color.GRAY);
 
		    if ((vyskaVstupu / 100) > (sirkaVstupu / 150)) {	// pokud je obrazek na vysku
			     vstupniSoubor.rescale((sirkaVstupu * 100 / vyskaVstupu), 100);
			     vystupniSoubor.pasteFrom(vstup, 0, 0);
		    } else {
			     vstupniSoubor.rescale(150, (vyskaVstupu * 150 / sirkaVstupu));
			     vystupniSoubor.pasteFrom(vstupniSoubor, 0, 0);
		    }
 
          awh.Image obrazek = awh.Image.loadFromFile(vstupniSoubor);
          obrazek.rescale(sirka, vyska);
          obrazek.saveToFile(vystupniSoubor);
    }
}