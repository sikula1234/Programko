public class TestMnohoclenu {    
    public static void main(String[] args) {
		
		Mnohoclen m1 = new Mnohoclen(6, 0, -5, 3);
		Mnohoclen m2 = new Mnohoclen(17, 2, 3);
		Mnohoclen m3 = new Mnohoclen(2, 3, 4);
		
		m1.pricti(m2);
		
		for (int i = 0; i < m1.koeficienty.length; i++) {
			System.out.printf("%d ", m1.koeficienty[i]);
		}
		System.out.println();
		
		m1.odecti(m2);
		
		for (int i = 0; i < m1.koeficienty.length; i++) {
			System.out.printf("%d ", m1.koeficienty[i]);
		}
		System.out.println();
		
		m1.vynasob(m3);
		
		for (int i = 0; i < m1.koeficienty.length; i++) {
			System.out.printf("%d ", m1.koeficienty[i]);
		}
		System.out.println();
		
	}
}