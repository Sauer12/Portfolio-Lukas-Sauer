package sk.lukas.sauer;

public class Cat extends Animal {

	@Override
	public void move() {
		System.out.println("Skacem");
		
	}

	@Override
	public void eat() {
		System.out.println("Papam ryby");		
	}
	
	public void sleep() {
		System.out.println("Spim");
	}
	
	
	
}
