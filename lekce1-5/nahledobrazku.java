public class nahledobrazku {
    public static void main(String[] args) {
        
        awh.Image vstup = awh.Image.loadFromFile(args[0]);
		int sirkavstupu = vstup.getWidth();
        int vyskavstupu = vstup.getHeight();
		
		awh.Image vystup = awh.Image.createEmpty(150, 100, awh.Color.GRAY);
 
		if ((vyskavstupu / 100) > (sirkavstupu / 150)) {	// pokud je obrazek na vysku
			vstup.rescale((sirkavstupu * 100 / vyskavstupu), 100);
			vystup.pasteFrom(vstup, 0, 0);
		} else {
			vstup.rescale(150, (vyskavstupu * 150 / sirkavstupu));
			vystup.pasteFrom(vstup, 0, 0);
		}
		
		vystup.saveToFile(args[1]);
        
    }                
}