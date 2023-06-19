package sk.lukas.sauer;

public class Main {
	
	public static void main(String[] args) {
		Animal animal = new Dog("Rex",10);
		Cat cat = new Cat();
		((Dog)animal).eat();
		System.out.println(((Dog)animal).vek);
		cat.move();		
		cat.eat();
		cat.sleep();
	}
}
