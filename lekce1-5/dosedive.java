public class dosedive {
    public static void main(String[] args) {
        
        awh.Image vstup = awh.Image.loadFromFile(args[0]);
		int sirka = vstup.getWidth();
        int vyska = vstup.getHeight();
 
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                awh.Color puvodni = vstup.getPixel(x, y);
                awh.Color nova = awh.Color.fromRgb(
                        ((puvodni.getRed() + puvodni.getGreen() + puvodni.getBlue()) / 3),
                        ((puvodni.getRed() + puvodni.getGreen() + puvodni.getBlue()) / 3),
                        ((puvodni.getRed() + puvodni.getGreen() + puvodni.getBlue()) / 3)
                );
                vstup.setPixel(x, y, nova);
            }
        }
		
		vstup.saveToFile(args[1]);
        
    }                
}