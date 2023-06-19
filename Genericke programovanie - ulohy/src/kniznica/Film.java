package kniznica;

public class Film extends Medium{
	
	public Film(String nazov) {
		this.nazov = nazov;
	}
	
	@Override
	public String toString() {
		return "Film";
	}
}
