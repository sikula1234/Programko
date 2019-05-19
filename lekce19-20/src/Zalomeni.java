import java.util.Scanner;

public class Zalomeni {
	
	public static final int maxZnaku = 25;
	static int znaku = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String slovo = sc.next();
			if (slovo.equals("")) {
				System.out.print("\n");
			}
			int delkaSlova = slovo.length();
			if (znaku == 0 ) {
				System.out.print(slovo);
				znaku += delkaSlova;
			} else if (znaku + delkaSlova < maxZnaku) {
				System.out.print(" " + slovo);
				znaku += delkaSlova + 1;
			} else {
				System.out.print("\n");
				System.out.print(slovo);
				znaku = delkaSlova + 1;
			}
		}
	}
	
}
