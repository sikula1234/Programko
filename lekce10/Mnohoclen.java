public class Mnohoclen {
	
	public int koeficienty[];
	
	public Mnohoclen(int... cisla) {
		koeficienty = cisla;
	}
	
	public void pricti(Mnohoclen m2) {
		int delkaDelsiho = (this.koeficienty.length >= m2.koeficienty.length) ? this.koeficienty.length : m2.koeficienty.length;
		int soucet[] = new int[delkaDelsiho];
		
		for (int i = 0; i < this.koeficienty.length; i++) {
			soucet[i] += this.koeficienty[i];
		}
		
		for (int i = 0; i < m2.koeficienty.length; i++) {
			soucet[i] += m2.koeficienty[i];
		}
		
		koeficienty = soucet;
	}
	
	public void odecti(Mnohoclen m2) {
		int delkaDelsiho = (this.koeficienty.length >= m2.koeficienty.length) ? this.koeficienty.length : m2.koeficienty.length;
		int rozdil[] = new int[delkaDelsiho];
		
		for (int i = 0; i < this.koeficienty.length; i++) {
			rozdil[i] += this.koeficienty[i];
		}
		
		for (int i = 0; i < m2.koeficienty.length; i++) {
			rozdil[i] -= m2.koeficienty[i];
		}
		
		koeficienty = rozdil;
	}

	public void vynasob(Mnohoclen m2) {
		int delkaSoucinu = this.koeficienty.length + m2.koeficienty.length - 1;
		int soucin[] = new int[delkaSoucinu];
		
		for (int i = 0; i < this.koeficienty.length; i++) {
			for (int j = 0; j < m2.koeficienty.length; j++) {
				soucin[i+j] += this.koeficienty[i] * m2.koeficienty[j];
			}
		}
		
		koeficienty = soucin;
	}
}