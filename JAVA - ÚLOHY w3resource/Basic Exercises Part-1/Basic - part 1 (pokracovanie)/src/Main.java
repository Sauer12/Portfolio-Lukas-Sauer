
public class Main {

	public static void main(String[] args) {
		
//		deliteleCisla(25);
//		velkeZaciatocnePismena("the quick brown fox jumps over the lazy dog.");
//		premenTextNaMalePismena("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.");
//		najdiPredposledneSlovo("The quick brown fox jumps over the lazy crazy dog.");
//		obratSlovo("Lukáš");
//		System.out.println(hodnoty(15, 20, 50));
//		System.out.println(mensieVacsie(12, 18));
//		System.out.println(cisliceVCislach(35, 45));
		
//		modulo(20, 7);
//		System.out.println(1 % 2);
//		prvocisla(100);
//		prvocisla(50);
//		vlozRetazec("Tutorial", "Python 3.0");
//		kopiaRetazca("Luxy");
		
//		polovicaRetazca("Python");
//		shortLongString("Lukáš", "pes");
//		stringConnection("Python", "Tutorial");
//		threeCharacters("Karol");
//		firstAndLast("Java", "Karol");
//		desiatkaVPoli(new int[] {10, 20, 15, 25, 10});
		
		int pole1[] = new int[] { 12, 10, 15, 20 };
		int pole2[] = new int[] { 1, 15, 20, 10 };
		
//		rovnakePolia(pole1, pole2);
//		firstLastElements(pole1, pole2);
		
	}
	
//	1. Spocita pocet delitelov v cisle
	public static void deliteleCisla(int cislo) {
		int pocetDelitelov = 0;
		
		for(int i = cislo; i > 0; i--) {
			if(cislo % i == 0) {
				pocetDelitelov++;
			}
		}
		
		System.out.println(pocetDelitelov);
	}

//	2. Zobere text a zmeni kazde prve pismeno slova na velke
	public static void velkeZaciatocnePismena(String text) {
		String velkePismeno = text.toUpperCase();
		StringBuilder velkyText = new StringBuilder(text);
		
		for(int i = 0; i < text.length(); i++) {
			if(i != 0) {
				if(text.charAt(i - 1) == ' ') {
					velkyText.setCharAt(i, velkePismeno.charAt(i));
				}
			}
			
			if(i == 0 && text.charAt(i) != ' ') {
				velkyText.setCharAt(i, velkePismeno.charAt(i));
			}			
		}
		
		System.out.println(velkyText);
	}
	
//	3. Premeni string na male pismena
	public static void premenTextNaMalePismena(String text) {
		text = text.toLowerCase();
		System.out.println(text);
	}
	
//	4. Najde predposledne slovo vo vete
	public static void najdiPredposledneSlovo(String text) {
		String[] rozdeleneSlova;
		rozdeleneSlova = text.split(" ");
		String predposledneSlovo = rozdeleneSlova[rozdeleneSlova.length - 2];
		
		System.out.println(text + "\n" + "Predposledne slovo: " + predposledneSlovo);		
	}
	
//  5. Zoberie slovo a obrati ho
	public static void obratSlovo(String text) {
		String obratenyText = "";
		
		for(int i = (text.length() - 1); i >= 0; i--) {
			obratenyText += text.charAt(i);
		}
		
		System.out.println(obratenyText);
	}

//  PREROBIT!!! - 6. Zoberie 3 int hodnoty a ak je jedna z nich viac ako 20 a zaroven menej ako odcitanie dvoch odstatnych, vrati true. 
	public static boolean hodnoty(int a, int b, int c) {
		int pomocna = 0;
		
		if(a < b && b < c) {
			pomocna = a;
			a = c;
			c = pomocna;
		}
		else if(a < b && b > c) {
			if(a < c) {
				pomocna = a;
				a = b;
				b = c;
				c = pomocna;
			}
			else {
				pomocna = a;
				a = b;
				b = pomocna;
			}			
		}
		
		
		if(a >= 20 || b >= 20 || c >= 20) {
			if(a >= 20) {
				if(b > c) {
					if(a < (b - c)) {
						return true;
					}
				}
				else if(c > b){
					if(a < (c - b)) {
						return true;
					}
				}
				else
					return false;
			}			
			else if(b >= 20) {
				if(a > c) {
					if(b < (a - c)) {
						return true;
					}
				}
				else if(c > a){
					if(b < (c - a)) {
						return true;
					}
				}
				else
					return false;
			}			
			else {
				if(a > b) {
					if(c < (a - b)) {
						return true;
					}
				}
				else if(a < b){
					if(c < (b - a)) {
						return true;
					}
				}
				else
					return false;
			}				
		}
		
		return false;
	}
	
//	7. Bere dve cisla a vrati vacsia z nich, ak su rovnake, vrati 0 a ak maju rovnaky zvysok po deleni vrati mensie
	public static int mensieVacsie(int a, int b) {
		if(a > b) {
			if(a % 6 == b % 6)
				return b;
			else
				return a;
		}
		else if(b > a) {
			if(a % 6 == b % 6)
				return a;
			else
				return b;
		}
		else
			return 0;
	}

//  8. Berie dve cisla od 25 do 75 a vrati true, ak maju aspon jednu rovnaku cislicu
	public static boolean cisliceVCislach(int a, int b) {
		if((a >= 25 && a <= 75) && (b >= 25 && b <= 75)) {
			String cisloA = String.valueOf(a);
			String cisloB = String.valueOf(b);
			
			if(cisloA.contains(cisloB.substring(0, 1)) || cisloA.contains(cisloB.substring(1, 2))) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
//	9. Modulo bez operatora modulo
	public static void modulo(int cislo, int delitel) {
		System.out.println(cislo - ((cislo/delitel) * delitel));
	}
	
//	10. sucet N prvocisiel, ktore su zadane v parametri
	public static void prvocisla(int pocetPrvocisiel) {
		
		boolean isPrvocislo = true;
		int cislo = 2;
		int prvocislo = 0;
		int sucet = 0;
		
		while(prvocislo < pocetPrvocisiel) {
			
			for(int i = 2; i < cislo; i++) {
				if(cislo % i == 0) {
					isPrvocislo = false;
					break;
				}
			}
			
			if(isPrvocislo) {
				sucet += cislo;
				cislo++;
				prvocislo++;
			}
			else {
				cislo++;
				isPrvocislo = true;
			}			
		}
		
		System.out.println(sucet);
	}

//	11. Vlozi retazec do stredu ineho retazca
	public static void vlozRetazec(String retazec, String text) {
		int pocetSlov = 0;
		String slova[] = text.split(" ");
		String upravenyRetazec = "";
		
		for(int i = 0; i < slova.length; i++) {
			if(slova.length / 2 == i) {
				upravenyRetazec += " " + retazec + " ";
			}				
			upravenyRetazec += slova[i];
		}		
		
		System.out.println(upravenyRetazec);
	}
	
//	12. Vytvori 4 kopie povodneho retazca, dlzka povodneho retazca musi byt minimalne 3 znaky
	public static void kopiaRetazca(String retazec) {
		String kopia = "";
		
		if(retazec.length() >= 3) {
			kopia += retazec + retazec + retazec + retazec;
			System.out.println(kopia);
		}
		else {
			System.out.println("Retazec je prilis kratky");
		}
		
		
		
	}
	
//	13. Vypise prvu polovicu retazca ak jeho pocet znakov je parny
	public static void polovicaRetazca(String text) {
		String podretazec = "";
		
		if(text.length() % 2 == 0) {
			for(int i = 0; i < text.length() / 2; i++) {
				podretazec += text.charAt(i);
			}
		}
		
		System.out.println(podretazec);
	}
	
//	14. Short x Long x Short String
	public static void shortLongString(String s1, String s2) {
		String s1s2 = "";
		
		if(s1.length() > s2.length()) {
			s1s2 = s2 + s1 + s2;
		}
		else {
			s1s2 = s1 + s2 + s1;
		}
		
		System.out.println(s1s2);
	}

//  15. Spojenie dvoch stringov s odstranenim prveho znaku v kazdom stringu
	public static void stringConnection(String s1, String s2) {
		String s1s2 = "";
		
		if(s1.length() >= 1 && s2.length() >= 1) {
			s1s2 = s1.substring(1) + s2.substring(1);
		}
		
		System.out.println(s1s2);
	}

//  16. Tri znaky
	public static void threeCharacters(String s) {
		String finalForm = "";
		
		if(s.length() < 3) {
			finalForm = "###";
		}
		else {
			for(int i = 0; i < 3; i++) {
				finalForm += s.charAt(i);
			}
		}
		
		System.out.println(finalForm);
	}

//	17. Prvy a posledny znak
	public static void firstAndLast(String s1, String s2) {
		String s = "";
		
		if(s1.length() == 0 && s2.length() != 0) {
			s += "#" + s2.charAt(s2.length() - 1);
		}
		else if(s1.length() != 0 && s2.length() == 0) {
			s += s1.charAt(0) + "#";
		}
		else if(s1.length() != 0 && s2.length() != 0){
			s += s1.charAt(0);
			s += s2.charAt(s2.length() - 1);
		}
		else {
			s += "##";
		}
		
		System.out.println(s);
	}
	
//	18. Zisti ci sa v poli cisiel objavi na zaciatku alebo na konci cislo 10
	public static void desiatkaVPoli(int pole[]) {
		
		if(pole.length >= 2) {
			if(pole[0] == 10 || pole[pole.length - 1] == 10) {
				System.out.println("true");
			}
			else
				System.out.println("false");
		}
		
	}
	
//	19. Zisti ci prve alebo posledne elementy v dvoch poliach su rovnake
	public static void rovnakePolia(int pole1[], int pole2[]) {
		if(pole1.length >= 2 && pole2.length >= 2) {
			if((pole1[0] == pole2[0]) || (pole1[pole1.length - 1] == pole2[pole2.length - 1])) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		}
	}
	
//	20. Vytvori z dvoch poli nove pole v ktorom bude obsahovat prvy element z prveho pola a posledny element z druheho pola
	public static void firstLastElements(int pole1[], int pole2[]) {
		int pole3[] = new int[2];
		
		if(pole1.length >= 1 && pole2.length >= 1) {
			pole3[0] = pole1[0];
			pole3[1] = pole2[pole2.length - 1];
		}
		
		for(int i : pole3) {
			System.out.println(i);
		}
	}
	
}


