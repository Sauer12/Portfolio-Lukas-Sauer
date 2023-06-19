import java.util.Random;
import heroes.Hero;

public class Hra {
	public Hero hero1;
	public Hero hero2;
	Random random;
	
	public Hra(Hero hero1, Hero hero2) {
		this.hero1 = hero1;
		this.hero2 = hero2;
		random = new Random();
	}
	
	public void play() {
		intro();
		boolean first = firstMove();
		while(!hero1.isDeath() && !hero2.isDeath()) {
			if(first) {
				hero1.attack(hero2);
				System.out.println(hero2);
				first = false;
			}
			else {
				hero2.attack(hero1);
				first = true;
				System.out.println(hero1);
			}
		}			
	}
	
	public void intro() {
		System.out.println("Vytajte v hre!\nV dnesnom suboji sa proti sebe postavia hrdinovia:\n\nPlayer1\n" + hero1 + "\nPlayer2\n" + hero2);
	}
	
//	Metoda urci, ktory hrac zacne
	public boolean firstMove() {
		boolean first = true;
		int rand = random.nextInt((2 - 1) + 1) + 1;
		if(rand == 1) {
			System.out.println("Zacina prvy hrac");
		}
		else if(rand == 2) {
			System.out.println("Zacina druhy hrac");
			first = false;
		}
		return first;
	}
}
