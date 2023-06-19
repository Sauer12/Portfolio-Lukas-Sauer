package sk.lukas.sauer;

public class Dog extends Animal{

	Dog(String druh, int vek){
		this.druh = druh;
		this.vek = vek;
	}
	
	@Override
	public void move() {
		System.out.println("hybem sa");
		
	}

	@Override
	public void eat() {
		System.out.println("Zerem granule");
		
	}
	
}
