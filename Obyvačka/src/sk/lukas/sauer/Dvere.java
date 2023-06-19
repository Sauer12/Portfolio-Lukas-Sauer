package sk.lukas.sauer;

public class Dvere extends Nabytok {
	
	public Dvere(String farba, String material) {
		super(farba, material);
	}
	
	public void zatvor() {
		System.out.println("Zatvoril si dvere.");
	}
	
	public void otvor() {
		System.out.println("Otvoril si dvere.");
	}	
	
	@Override
	public String toString() {
		return "Dvere -> Farba: " + farba + ", " + "Material: " + material;
	}
}
