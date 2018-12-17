public class Scitani {
	public static void main(String[] args) {

		java.util.Random nahoda = new java.util.Random();

		for (int i = 0; i < 10; i++) {
			int a = nahoda.nextInt(21);
			int b = nahoda.nextInt(21 - a);
			System.out.printf("%d + %d = %d\n", a, b, a + b);
		}

	}
}