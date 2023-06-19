import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pole[] = new int[] {
				10, 15, 3, 4, 2, 20, 1
		};
		
		int pole2[] = new int[] {
				1, 2, 3, 4, 5, 10, 12
		};
		
//		cislaVPoli(new int[] {5,4,1,2} );
//		rotujPole(new int[] {10, 5, 4, 3, 7});
//		najHodnotaVPoli(pole);
//		vymenHodnotu(pole);
//		vynasobPrvky(pole, pole2);
//		threeEndingCharacters("Python");
//		startWithWord("Ahoj som Java", sc);
//		divneCislo(1000);
//		sucetCislic(sc);
//		systemProperties();
	}

//	1. Otestuje ci pole obsahuje cislo 4 alebo 7
	public static void cislaVPoli(int pole[]) {
		boolean obsahuje = false;
		
		for(int i : pole) {
			if(i == 4 || i == 7) {
				obsahuje = true;
			}
		}
		
		System.out.println(obsahuje);
	}
	
//	2. Rotuje vnutro pola o jeden prvok do lava
	public static void rotujPole(int pole[]) {
		int pomocna = 0;
		
		for(int i = 0; i < pole.length; i++) {
			
			if(i == 0) {
				pomocna = pole[i];				
			}
			
			if(i != pole.length - 1) {
				pole[i] = pole[i + 1];				
			}
			else {
				pole[i] = pomocna;
			}
		}
		
		for(int i : pole) {
			System.out.println(i);
		}
	}
	
//	3. Najde najvacsiu hodnotu v poli
	public static void najHodnotaVPoli(int pole[]) {
		int najvacsiaHodnota = 0;
		
		for(int i = 0; i < pole.length; i++) {
			if(najvacsiaHodnota < pole[i]) {
				najvacsiaHodnota = pole[i];
			}
		}
		
		System.out.println(najvacsiaHodnota);
	}
	
//	4. Vymeni prvu a poslednu hodnotu v poli
	public static void vymenHodnotu(int pole[]) {
		if(pole.length >= 2) {
			int pomocna = pole[0];
			pole[0] = pole[pole.length - 1];
			pole[pole.length - 1] = pomocna;
		}
		
		for(int i : pole) {
			System.out.println(i);
		}
	}

//  5. Vynasobi prvky pola s prvkami druheho pola
	public static void vynasobPrvky(int pole1[], int pole2[]) {
		if(pole1.length == pole2.length) {
			for(int i = 0; i < pole1.length; i++) {
				System.out.println(pole1[i] * pole2[i]);
			}
		}
	}
	
//	6. Zobere String a posledne tri znaky Stringu prida na zaciatok a na koniec Stringu
	public static void threeEndingCharacters(String s) {
		if(s.length() > 3) {
			String lastCharacters = "";
			for(int i = s.length() - 3; i < s.length(); i++) {
				lastCharacters += s.charAt(i);
			}
			
			System.out.println(lastCharacters + s + lastCharacters);
		}
	}
	
//	7. Skontroluje, ci retazec zacina na dane slovo zadane uzivatelom
	public static void startWithWord(String s, Scanner sc) {
		String hladaneSlovo = sc.nextLine();
		String slova[] = s.split(" ");
		if(slova[0].equals(hladaneSlovo)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}

//	8. Bere int, ktory ak je parny vydeli dvojkou, ak je neparny, vynasobi ho trojkou a prida 1
	public static void divneCislo(int n) {
		while(n != 1) {
			if(n % 2 == 0) {
				n = n / 2;
			}
			else {
				n = n * 3 + 1;
			}
			System.out.println(n);
		}
	}

//	9. Zobere cislo, spocita sucet jeho cislic a vypise nazov kazdej jednej cislice 
	public static void sucetCislic(Scanner sc) {
		System.out.print("Zadaj èíslo: ");
		String cislo = sc.nextLine();
		String[] cislice = new String[] {
				"Nula", "Jedna", "Dva", "Tri", "Štyri", "Pä", "Šes", "Sedem", "Osem", "Devä"
		};
		int sum = 0;
		
		for(int i = 0; i < cislo.length(); i++) {
			sum += Character.getNumericValue(cislo.charAt(i));
			for(int j = 0; j < cislice.length; j++) {
				if(j == Character.getNumericValue(cislo.charAt(i))){
					System.out.println(j + " -> " + cislice[j]);
				}
			}
		}
		
		System.out.println("Súèet èislic: " + sum);		
	}

//	10. Systemove informacie
	public static void systemProperties() {
		System.out.println(System.getenv());
		System.out.println(System.getProperties());
	}

//  11. 
}
