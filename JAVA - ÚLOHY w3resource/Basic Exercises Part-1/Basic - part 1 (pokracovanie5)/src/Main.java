import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] pole = new int[] {15, 30, 31, 32, 33, 32, 30, 5};
		int[] pole2 = new int[] {1, 5, 2, 3, 40, 55};
//		1.
//		System.out.println("Je v poli viacej desiatok ako dvadsiatok: " + pocetDesatVsPocetDvadsat(pole));
//		2.
//		System.out.println("Obsahuje pole 10 alebo 30?: " + obsahujeDesatOrTridsat(pole));
//		3.
//		subPole(pole);
//		4.
//		subPoleBefore(pole);
//		5.
//		System.out.println("Rovnaju sa skupiny cisiel na zaciatku a konci cisla?: " + groupsOfArray(pole, 1));
//		6.
//		posunuteSubPole(pole);
//		7.
//		System.out.println(rastuceCisla(pole));
//		8.
//		jednaCislica(9999);
//		9.
//		schody(30);
//		10.
//		System.out.println(mocninaStvorky(1024));
//		11.
//		System.out.println(koncoveNulyFaktorial(10));
//		12.
//		spojAZotriedPolia(pole, pole2);
//		13.
//		rotujRetazec("Lukáš", 2);
//		14.
//		System.out.println(palindrom(sc));
//		15.
		System.out.println(prvyVyskytPodretazca("Amaterasu", "ra"));
}
	
//	1. Zisti ci je v poli viacej cisiel 10 ako 20 a vrati true alebo false ak ich nie je viac
	public static boolean pocetDesatVsPocetDvadsat(int[] pole) {
		int pocetDesiatok = 0;
		int pocetDvadsiatok = 0;
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10)
				pocetDesiatok++;
			else if(pole[i] == 20)
				pocetDvadsiatok++;
		}
			
		if(pocetDesiatok > pocetDvadsiatok)
			return true;
			
		return false;
	}

//	2. Zisti ci dane pole obsahuje 10 alebo 30
	public static boolean obsahujeDesatOrTridsat(int[] pole) {
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10 || pole[i] == 30) {
				return true;
			}
		}
		
		return false;
	}

//	3. Urobi subpole s prvkami z daneho pola zacinajuce od poslednej desiatky sa v danom poli.
	public static void subPole(int[] pole) {
		int index = pole.length;
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10) {
				index = i;
			}
		}
		
		int[] subPole = new int[pole.length - index];
		
		for(int i = index, j = 0; i < pole.length; i++, j++) {
			subPole[j] = pole[i];
		}
		
		for(int i : subPole) {
			System.out.print(i + " ");
		}
	}	

//	4. Urobi subpole s prvakmi z daneho pola zo vsetkych prvkov pred poslednou desiatkou v danom poli
	public static void subPoleBefore(int[] pole) {
		
		int index = pole.length;
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10)
				index = i;
		}
		
		if(index < pole.length) {
			int[] subPole = new int[index + 1];
			for(int i = index; i >= 0; i--) {
				subPole[i] = pole[i];
			}
			
			for(int i : subPole) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("Pole sa nevytvorilo, lebo nadpole neobsahuje 10");
		}			
		
	}

//	5. Skontroluje, ci je skupina cisiel (N) na zaciatku pola a na konci pola rovnaka
	public static boolean groupsOfArray(int[] pole, int velkostSkupiny) {
		boolean control = false;
		
		if(pole.length > velkostSkupiny && velkostSkupiny <= pole.length / 2) {
			for(int i = 0; i < velkostSkupiny; i++) {
				if(pole[i] == pole[pole.length - velkostSkupiny + i]) {
					control = true;
				}
				else {
					return false;
				}
			}
		}
			
		return control;
	}

//  6. Vytvori subpole a posunie prvky v subpoli o miesto dolava
	public static void posunuteSubPole(int[] pole) {
		int[] subpole = new int[pole.length];
		
		for(int i = 0, j = -1; i < pole.length; i++, j++) {
			if(i == 0)
				subpole[pole.length - 1] = pole[i];
			else
				subpole[j] = pole[i];
		}
		
		for(int i : subpole) {
			System.out.print(i + " ");
		}
		
	}
	
//	7. Zisti ci pole obsahuje 3 po sebe rastuce cisla
	public static boolean rastuceCisla(int[] pole) {
		int pocet = 0;
		
		for(int i = 0; i < pole.length; i++) {
			if(i + 1 < pole.length) {
				if(pole[i] + 1 == pole[i+1]) {
					pocet++;
					if(pocet == 3)
						return true;
				}
				else {
					pocet = 0;
				}
			}
		}
		
		return false;
	}

//	8. Zobere int a bude spocitavat jeho cislice az dovtedy, dokym vysledok nebude mat jednu cislicu
	public static void jednaCislica(int cislo) {
		String s = String.valueOf(cislo);
		System.out.println(s);
		cislo = 0;
		
		while(s.length() > 1) {
			for(int i = 0; i < s.length(); i++) {
				cislo += Character.getNumericValue(s.charAt(i));
			}
			s = String.valueOf(cislo);
			if(s.length() > 1)
				cislo = 0;
		}
		
		System.out.println(cislo);
	}	

//	9. Bere pocet schodov a na zaklade toho ich vykresli
	public static void schody(int pocetDielcov) {
		int radSchodov = 1;
		int pocetSchodov = 0;
		
		while(pocetDielcov > 0) {
			for(int i = 0; i < radSchodov; i++) {
				System.out.print("$");
				pocetDielcov--;				
				if(i + 1 == radSchodov) {
					pocetSchodov++;
				}
				if(pocetDielcov == 0) {
					break;
				}
			}
			radSchodov++;
			System.out.println();
		}
		
		System.out.println("Pocet schodov: " + pocetSchodov);
		
	}

//  10. Zisti ci je dane cislo mocninou 4 alebo nie
	public static boolean mocninaStvorky(int cislo) {
		int mocninyStvorky = 4;
		
		for(int i = 1; i < cislo; i++) {
			if(mocninyStvorky == cislo) {
				return true;
			}
			mocninyStvorky *= 4;
		}
		
		return false;
	}

//  11. Vypocet koncovych 0 vo faktoriale
	public static int koncoveNulyFaktorial(int faktorial) {
		
		for(int i = faktorial - 1; i > 0; i--) {
			faktorial *= i;
		}
		
		String fakt = String.valueOf(faktorial);
		int pocetNul = 0;
		
		for(int i = 0; i < fakt.length(); i++) {
			if(fakt.charAt(i) == '0') {
				pocetNul++;
			}
			else
				pocetNul = 0;
		}
		
		return pocetNul;
	}
	
//	12. Bere dve polia a ich prvky spoji a vytvori zotriedene pole
	public static void spojAZotriedPolia(int pole1[], int pole2[]) {
		int[] novePole = new int[pole1.length + pole2.length];
		
		for(int i = 0; i < pole1.length; i++) {
			novePole[i] = pole1[i];
		}
		for(int i = pole1.length - 1, j = 0; i < pole2.length + pole1.length - 1; i++, j++) {
			novePole[i] = pole2[j];
		}
		
		Arrays.sort(novePole);
		
		for(int i : novePole) {
			System.out.print(i + " ");
		}
	}

//	13. Zobere retiazec a velkost posunu, na zaklade toho posunie znaky v retazci smerom dolava o velkost posunu
	public static void rotujRetazec(String s, int velkostPosunu) {
		String posunutyRetazec = "";
		
		if(velkostPosunu <= s.length()) {
			posunutyRetazec = s.substring(velkostPosunu);
			for(int i = 0; i < velkostPosunu; i++) {
				posunutyRetazec += s.charAt(i);
			}			
			System.out.println(posunutyRetazec);
		}
		else {
			System.out.println("Velkost posunu je vacsia ako dlzka retazca");
		}
		
	}

//	14. Zisti, ci je zadany retazec palindrom
	public static boolean palindrom(Scanner sc) {
		System.out.print("Zadaj retazec: ");
		String s = sc.nextLine().toLowerCase();
		
		for(int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		
		return true;			
	}

//	15. Skusi najst podretazec v retazci a vrati jeho posledny index
	public static int prvyVyskytPodretazca(String s, String hladanyRetazec) {
		
		for(int i = 0, j = 0; i < s.length(); i++) {			
			if(j == hladanyRetazec.length() - 1)
				return i;	
			
			if(s.charAt(i) == hladanyRetazec.charAt(j)) {
				j++;
			}
			else {
				j = 0;
			}					
		}
		
		return 0;
	}
	
}
