import java.util.Random;

import heroes.*;

public class Main {

	public static void main(String[] args) {
		Hunter hunter = new Hunter("Luxy", 1, 100, 100, 10, 5);
		Hunter hunter2 = new Hunter("Pepe", 2, 100, 100, 10, 5);
		Hra hra = new Hra(hunter, hunter2);
		hra.play();
		
		
//		Random random = new Random();
//		System.out.println(random.nextFloat() * 100);
	}

}
