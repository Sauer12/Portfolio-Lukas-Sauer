package sk.lukas.sauer;

public class Skrina extends Nabytok {
	
	public Skrina(String farba, String material) {
		super(farba, material);
	}
	
	public void otvor() {
		System.out.println("Otvoril si skrinu.");
	}
	
	public void zatvor() {
		System.out.println("Zatvoril si skrinu");
	}
	
	@Override
	public String toString() {
		return "Skrina -> Farba: " + farba + ", Material: " + material; 
	}
	
}
