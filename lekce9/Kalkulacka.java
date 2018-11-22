public class Kalkulacka {
  public static void main(String[] args) {
       
    int vysledek = 0;
        
    String[] scitance = args[0].split("\\+");
    for (int i = 0; i < scitance.length; i++)  {
      String[] cinitele = scitance[i].split("x");
      int soucin = Integer.parseInt(cinitele[0]);
      for (int j = 1; j < cinitele.length; j++) {
        soucin *= Integer.parseInt(cinitele[j]);
      }
      vysledek += soucin;
    }
      
    System.out.printf("%d", vysledek); 
        
  }                
}