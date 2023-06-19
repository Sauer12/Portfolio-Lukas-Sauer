package sk.lukas.sauer;

public class Nabytok {
	
	protected String farba;
	protected String material;
	
	public Nabytok(String farba, String material) {
		this.farba = farba;
		this.material = material;
	}
	
	protected void umiestni() {
		System.out.println("Umiestnil si nabytok.");
	}
	
	protected void odstran() {
		System.out.println("Odstranil si nabytok.");
	}

}
