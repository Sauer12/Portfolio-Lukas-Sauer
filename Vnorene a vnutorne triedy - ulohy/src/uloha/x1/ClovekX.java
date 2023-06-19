package uloha.x1;

public class ClovekX {
	public int vek;
	public String meno;
	public String priezvisko;
	public AdresaX adresa;
	
	public ClovekX(int vek, String meno, String priezvisko) {
		this.vek = vek;
		this.meno = meno;
		this.priezvisko = priezvisko;
	}
	
	public void pridajAdresu(AdresaX adresa) {
		this.adresa = adresa;
	}
	
	class AdresaX {
		public int cislo;
		public String nazov;
		public String obec;
		
		AdresaX(int cislo, String nazov, String obec) {
			this.cislo = cislo;
			this.nazov = nazov;
			this.obec = obec;
		}
	}
	
	@Override
	public String toString() {
		return meno + " " + priezvisko + ", " + adresa.obec;
	}
}
