package sk.lukas.sauer;

public class Obraz {
	
	public String autor;
	public String velkost;
	
	
	public Obraz() {
		
	}
	
	public Obraz(String autor, String velkost) {
		this.autor = autor;
		this.velkost = velkost;
	}
	
	public void zavesit() {
		System.out.println("Zavesil si obraz.");
	}
	
	public void zvasit() {
		System.out.println("Zvasil si obraz.");
	}
	
	
	
	@Override
	public String toString() {
		return "Toto je obraz";
	}
}
