public class DenVRoce {
    public static void main(String[] args) {
        
        int rok = Integer.parseInt(args[0]);
        int mesic = Integer.parseInt(args[1]);
        int den = Integer.parseInt(args[2]);
        int dnupredmesicem = 0;
        awh.IntList dnuvmesici = awh.IntList.create(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        
        for (int i = 0; i < mesic - 1; i++) {
          dnupredmesicem += dnuvmesici.get(i);
        }
        
        int denvroce = dnupredmesicem + den;
        
        if(jePrestupny(rok) && mesic > 2) {
          denvroce++;
        }
        
        System.out.printf("%d\n", denvroce);
    }
    
    public static boolean jePrestupny(int rok) {
      boolean prestupnost = false;
      if ((rok % 4) == 0) {prestupnost = true;}
      if ((rok % 100) == 0) {prestupnost = false;}
      if ((rok % 400) == 0) {prestupnost = true;}
      return prestupnost;
    }
}