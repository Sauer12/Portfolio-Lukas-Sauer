package uloha.x1;

public class Clovek {

	public int vek;
	public String meno;
	public String priezvisko;
	public Adresa adresa;
	
	public Clovek(int vek, String meno, String priezvisko, Adresa adresa) {
		this.vek = vek;
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.adresa = adresa;
	}
	
	@Override
	public String toString() {
		return meno + " " + priezvisko + ", " + adresa.obec;
	}
}
