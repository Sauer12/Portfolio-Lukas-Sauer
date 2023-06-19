package sk.lukas.sauer.people;

public class Player extends People{

	public Player(String role, int vek) {
		this.role = role;
		this.vek = vek;
	}
	
	@Override
	public void move() {
		System.out.println("Beham");		
	}
	
	public void obrana() {
		System.out.println("Obranujem");
	}
	
	public void hod() {
		System.out.println("Hadzem loptu na kos");
	}
	
	public void nahravka() {
		System.out.println("Nahravam loptu");
	}
	
	public void doskok() {
		System.out.println("Doskakujem loptu");
	}
	
}
