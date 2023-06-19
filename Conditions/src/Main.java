
public class Main {
	
	public static void main(String[] args) {
		int number = -5;
		
		if(number >= 0) {
			System.out.println("Number is positive");
		}
		else {
			System.out.println("Number is negative");
		}
		
		int numberOfDay = 3;
		
		if(numberOfDay == 1) {
			System.out.println("Je pondelok.");
		}
		else if(numberOfDay == 2) {
			System.out.println("Je utorok.");
		}
		else if(numberOfDay == 3) {
			System.out.println("Je streda.");	
		}
		else if(numberOfDay == 4) {
			System.out.println("Je stvrtok.");
		}
		else if(numberOfDay == 5) {
			System.out.println("Je piatok.");
		}
		else if(numberOfDay == 6) {
			System.out.println("Je sobota.");
		}
		else if(numberOfDay == 7){
			System.out.println("Je nedela.");
		}
		else {
			System.out.println("Neviem aky je den!");
		}
		
		int numberX = 5;
		int numberY = 1;
		int numberZ = 2;
		
		if(numberX > numberY && numberX > numberZ) {
			if(numberY > numberZ)
				System.out.println(numberX + ", " + numberY + ", " + numberZ);
			else
				System.out.println(numberX + ", " + numberZ + ", " + numberY);				
		}
		else if(numberY > numberX && numberY > numberZ) {
			if(numberX > numberZ)
				System.out.println(numberY + ", " + numberX + ", " + numberZ);
			else
				System.out.println(numberY + ", " + numberZ + ", " + numberX);
		}
		else {
			if(numberX > numberY)
				System.out.println(numberZ + ", " + numberX + ", " + numberY);
			else
				System.out.println(numberZ + ", " + numberY + ", " + numberX);				
		}
		
		
		if(numberX < numberY && numberX < numberZ) {
			if(numberY < numberZ)
				System.out.println(numberX + ", " + numberY + ", " + numberZ);
			else
				System.out.println(numberX + ", " + numberZ + ", " + numberY);				
		}
		else if(numberY < numberX && numberY < numberZ) {
			if(numberX < numberZ)
				System.out.println(numberY + ", " + numberX + ", " + numberZ);
			else
				System.out.println(numberY + ", " + numberZ + ", " + numberX);
		}
		else {
			if(numberX < numberY)
				System.out.println(numberZ + ", " + numberX + ", " + numberY);
			else
				System.out.println(numberZ + ", " + numberY + ", " + numberX);				
		}
		
		
		number = 4;
		
		if(number % 5 == 0 && number % 3 == 0) {
			System.out.println("FizzBuzz");
		}
		else if(number % 5 == 0) {
			System.out.println("Buzz");
		}
		else if(number % 3 == 0) {
			System.out.println("Fizz");
		}
		else
			System.out.println("Nie je delitelne ani trojkou ani patkou");
		
		int i = 1;
		
		while(i <= 10) {
			System.out.println(i);
			i++;
		}
		
		i = 1;
		
		while(i <= 100) {
			if(i % 2 == 0)
				System.out.println(i);
			i++;
		}
		
		i = 1;
		while(i <= 100) {
			if(i % 5 == 0)
				System.out.println(i);
			i++;
		}
		
		i = 1;
		int end = 20;
		String parne = "", neparne = "";
		
		
		while(i <= end) {
			if(i % 2 == 0)
				parne += i + " ";
			else
				neparne += i + " ";
			i++;
		}
		System.out.println(parne);
		System.out.println(neparne);
		
		
		for(int j = 4; j > 0; j--) {
			for(i = 1; i <= j; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		for(int j = 1; j <= 4; j++) {
			for(i = 1; i <= j; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		for(i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				if(j == i) {
					System.out.print("_ ");
				}
				else
					System.out.print(j + " ");					
			}
			System.out.println();
		}
		
		number = 10;
		
		System.out.println("Cislo 10 " + (number % 2 == 0 ? " je delitelne 2" : "nie je delitelne 2"));
		
		System.out.println("Cislo " + number + " " + (number > 10 ? "je vacsie alebo ako 10" : (number < 10 ? "je mensie ako 10" : "je rovne 10")));
		
		
//		if(numberX > numberY && numberY > numberZ) 
//			System.out.println(numberX + ", " + numberY + ", " + numberZ);
//		else if(numberX > numberY && numberY < numberZ && numberZ < numberX)
//			System.out.println(numberX + ", " + numberZ + ", " + numberY);
//		else if(numberY > numberX && numberX > numberZ)
//			System.out.println(numberY + ", " + numberX +", " + numberZ);
		
		
	}
}
