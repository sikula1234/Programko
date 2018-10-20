public class prvocislo {
  public static void main(String[] args) {
  
    int vstup = Integer.parseInt(args[0]);
    int x = 1;
    int delitel = 1;
    
    while (x < vstup) {
      if ((vstup % x) == 0) {
        delitel = x;      
      }
      x++;  
    }
    
    if (vstup <= 0) {
		System.out.print("Je nutne zadat prirozene cislo.\n");
	} else {
		if (delitel == 1) {System.out.printf("Vskutku, %d je prvocislo!\n", vstup);}
		else {System.out.printf("Nikoliv, %d neni prvocislo!\n", vstup);}
	}
  
  }
}