public class Otoceni {
    public static void main(String[] args) {
        
        awh.IntList sekvence = awh.IntList.create();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while(sc.hasNextInt()) {
          sekvence.add(sc.nextInt());  
        }
		
		for (int i = sekvence.size() - 1; i >= 0; i--) {
			System.out.printf("%d ", sekvence.get(i));
		}
        
	}
}