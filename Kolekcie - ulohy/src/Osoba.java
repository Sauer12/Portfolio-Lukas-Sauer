
public class Osoba {

	private String meno;
	private String priezvisko;
	private int vek;
	
	public Osoba(String meno, String priezvisko, int vek) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.vek = vek;
	}
	
	@Override
	public String toString() {
		return meno + ", " + priezvisko + ", " + vek;
	}
}
