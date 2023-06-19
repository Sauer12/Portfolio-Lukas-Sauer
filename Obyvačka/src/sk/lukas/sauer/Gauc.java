package sk.lukas.sauer;

public class Gauc extends Nabytok {

	public Gauc(String farba, String material) {
		super(farba, material);
	}
	
	public void sadnut() {
		System.out.println("Sadol si si na gauc.");
	}
	
	public void lahnut() {
		System.out.println("Lahol si si na gauc.");
	}
	
	public void postavitSa() {
		System.out.println("Postavil si sa z gauca.");
	}
	
	@Override
	public String toString() {
		return "Gauc -> Farba: " + farba + ", Material: " + material;
	}
	
}
