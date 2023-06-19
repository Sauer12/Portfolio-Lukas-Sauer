package kniznica;

public class Kniha extends Medium{
	
	public Kniha(String nazov) {
		this.nazov = nazov;
	}
	
	@Override
	public String toString() {
		return "Kniha";
	}
}
