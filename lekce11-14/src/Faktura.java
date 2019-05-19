import java.util.Scanner;

public class Faktura {
    private static final String[] ADRESA_PRODEJCE = {
        "Prodejna a.s.",
        "Horni dolni 42",
        "123 45"
    };
    
    public interface Tisk {
    	public void zahlavi();
    	public void zapati();
    	
    	public void nadpis(String s);
    	public void text(String s);
    	
    	public void polozkaZahlavi();
    	public void polozka(String nazev, int cena);
    	public void polozkaZapati();
    }
    
    public static class TextovyTisk implements Tisk {
		@Override public void zahlavi() {}
		@Override public void zapati() {}
		
		@Override public void polozkaZahlavi() {}
		@Override public void polozkaZapati() {}

		@Override
		public void nadpis(String s) {
			System.out.printf("\n>>>> %s\n\n", s);
		}

		@Override
		public void text(String s) {
			System.out.printf(" %s\n", s);
		}

		@Override
		public void polozka(String nazev, int cena) {
			System.out.printf(" %s ", nazev);
			for (int i = nazev.length(); i < 30 - Integer.toString(cena).length(); i++) {
				System.out.print(".");
			}
			System.out.printf(" %d\n", cena);
		}
    }
    
    public static class HtmlTisk implements Tisk {

		@Override
		public void zahlavi() {
			System.out.print("<!DOCTYPE html>\n<html>\n" + 
	    			"<head>\n" + 
	    			"	<meta charset=\"utf-8\" />\n" + 
	    			"	<title>Faktura</title>\n" + 
	    			"</head>\n" + 
	    			"<body>");
		}

		@Override
		public void zapati() {
			System.out.print("</body></html>\n");
		}

		@Override
		public void nadpis(String s) {
			System.out.printf("<h1>%s</h1>\n", s);
		}

		@Override
		public void text(String s) {
			System.out.printf(" <p>%s</p>\n", s);
		}

		@Override
		public void polozka(String nazev, int cena) {
			System.out.printf("<tr><td>%s</td><td align=\"right\">%d</td></tr>\n", nazev, cena);
		}

		@Override
		public void polozkaZahlavi() {
			System.out.printf("<table>\n");
		}

		@Override
		public void polozkaZapati() {
			System.out.printf("</table>\n");
		}
    }
 
    public static void main(String args[]) {
      //uwu
    	boolean doHtml = false;
    	if ((args.length > 0) && "html".equals(args[0])) {
    		doHtml = true;
    	}
    	Tisk vystup = doHtml ? new HtmlTisk() : new TextovyTisk();
    	
        Scanner sc = new Scanner(System.in);
 
        vystup.zahlavi();
        vystup.nadpis("Informace o zakaznikovi");
        while (sc.hasNextLine()) {
            String radka = sc.nextLine().trim();
            if (radka.isEmpty()) {
                break;
            }
            vystup.text(radka);
        }
 
        vystup.nadpis("Informace o prodejci");
        
        for (String s : ADRESA_PRODEJCE) {
        	vystup.text(s);
        }
 
        vystup.nadpis("Zakoupene zbozi");
        vystup.polozkaZahlavi();
        int suma = 0;
        while (sc.hasNextLine()) {
            String radka = sc.nextLine().trim();
            if (radka.isEmpty()) {
            	continue;
            }
            String[] casti = radka.split(";", 2);
            int cena = Integer.parseInt(casti[0]);
            String nazev = casti[1];
            vystup.polozka(nazev, cena);
            suma += cena;
        }
        vystup.polozka("SOUCET", suma);
        vystup.polozkaZapati();
        
        vystup.zapati();
    }
}
