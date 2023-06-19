
public class Auto {
	private String znacka;
	private int najazdeneKm;
	private int cena;
	
	public Auto(String znacka, int najazdeneKm, int cena) {
		this.znacka = znacka;
		this.najazdeneKm = najazdeneKm;
		this.cena = cena;
	}
	
	@Override
	public String toString() {
		return znacka;
	}
}
