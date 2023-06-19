//2. Osoba ktorej meno a priezvisko zadam cez input
public class Osoba {
	
	private String meno;
	private String priezvisko;
	
	public Osoba(String meno, String priezvisko) {
		this.meno = meno;
		this.priezvisko = priezvisko;
	}
	
	@Override
	public String toString() {
		return meno + " " + priezvisko;
	}

}
