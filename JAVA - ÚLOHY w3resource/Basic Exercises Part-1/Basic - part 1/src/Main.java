import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello world");
		System.out.println("Luk·ö Sauer");
		oddelovac();
		
		System.out.println("   J    a   v     v  a                                                  \r\n"
		+ "   J   a a   v   v  a a                                                 \r\n"
		+ "J  J  aaaaa   V V  aaaaa                                                \r\n"
		+ " JJ  a     a   V  a     a");
		oddelovac();
		oddelovac();
//		sum(50, 20);
//		divide(50, 0);
//		oddelovac();
//		basicMathOperations(10, 5);
//		oddelovac();
//		sumWithInput(sc);		
//		basicCalculator(sc);
//		multiplicationCycle(sc);
//		resultX();
//		resultA();
//		obvodAObsahKruhu(7.5);
//		priemerTrochCisiel(5, 5, 5);
//		obvodAObsahObdlznika(5, 5);
		
//		System.out.println("* * * * * * ==================================                          \r\n"
//				+ " * * * * *  ==================================                          \r\n"
//				+ "* * * * * * ==================================                          \r\n"
//				+ " * * * * *  ==================================                          \r\n"
//				+ "* * * * * * ==================================                          \r\n"
//				+ " * * * * *  ==================================                          \r\n"
//				+ "* * * * * * ==================================                          \r\n"
//				+ " * * * * *  ==================================                          \r\n"
//				+ "* * * * * * ==================================                          \r\n"
//				+ "==============================================                          \r\n"
//				+ "==============================================                          \r\n"
//				+ "==============================================                          \r\n"
//				+ "==============================================                          \r\n"
//				+ "==============================================                          \r\n"
//				+ "==============================================");
//		
//		
//		oddelovac();
//		oddelovac();
//		swap(5, 10);
//		oddelovac();
//		facePrint();
		
//		byte test = 10;
//		byte test2 = 11;
//		
//		binarySum(sc);
//		binaryMultiplication(sc);
//		decimalToBinary(sc);
		
//		javaInformation();
//		comparator(10, 5);
		
//		digitSum(255);
		
//		obsahHexagonu(6);
//		obratString("The quick brown fox");
		
//		analyzaStringu("Ahoj, volam sa Luk·ö Sauer, narodil som sa 1.2.2000");
//		threeDigitNumbers();
		
//		vypisZnakoveSady();
//		asciiHodnotaZnaku('A');
//		heslo(sc);
		
//		trippleInt(5);
//		velkostSuboru("src/test.txt");
//		zobrazDatumCas();
//		zobrazDatumCasVoFormate();
//		neparneCisla(1, 99);
//		neparneCisla(5, 200);
		
//		parnostNeparnost(19);
//		delitelnostTromiAPiatimi();
		
//		convertStringToInt("25");
//		sucet(5, 10, 15);
//		rightDigit(5, 152, 153);
//		porovananieCisiel(5, 10, 15);
		
//		premenSekundy();
//		rozsahHodnot(5, 20, 3);
//		delitelCisla(25);
		
		
		sc.close();
	}
	
	
	
	public static void oddelovac() {
		System.out.println("--------------------------");
	}
	
//	2.
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
//	3.
	public static void divide(int a, int b) {
		if(b != 0) {
			System.out.println(a/b);
		} else {
			System.out.println("Nemozes delit 0");
		}
		
	}
	
//	4.
	public static void basicMathOperations(int a, int b) {
		System.out.println("Scitanie: " + (a+b));
		System.out.println("Odcitanie: " + (a - b));
		System.out.println("Nasobenie: " + a * b);
		System.out.println("Delenie: " + (b != 0 ? a/b : "Nemozes delit 0"));
	}

//	5.
	public static void sumWithInput(Scanner sc) {
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		
		System.out.println("Vysledok: " + (a+b));
	}
	
//  6.
	public static void basicCalculator(Scanner sc) {
		System.out.print("Zadaj prve cislo: ");
		double a = Double.parseDouble(sc.nextLine());
		System.out.print("Zadaj druhe cislo: ");
		double b = Double.parseDouble(sc.nextLine());
		
		System.out.println("Scitanie: " + (a+b));
		System.out.println("Odcitanie: " + (a-b));
		System.out.println("Nasobenie: " + (a*b));
		System.out.println("Delenie: " + (b != 0 ? a/b : "Nemozes delit 0!"));
		oddelovac();		
	}

//  7.
	public static void multiplicationCycle(Scanner sc) {
		System.out.print("Zadaj cislo: ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("Do akeho poctu chces dane cislo nasobit?: ");
		int b = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= b; i++) {
			System.out.println(a * i);
		}
		oddelovac();
	}

//	9. 
	public static void resultX() {
		System.out.println((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
	}
	
//	10.
	public static void resultA() {
		System.out.println(4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11)));
	}

//	11. Kruh - obvod a obsah
	public static void obvodAObsahKruhu(double polomer) {
		double obsah = Math.PI * polomer * polomer;
		double obvod = 2 * Math.PI * polomer;
		System.out.println("Obsah kruhu: " + obsah);
		System.out.println("Obvod kruhu: " + obvod);
	}

//	12. Priemer troch cisiel
	public static void priemerTrochCisiel(double a, double b, double c) {
		double priemer = (a+b+c) / 3;
		System.out.println("Priemer cisiel je: " + priemer);
	}

//	13. Obdlznik - obvod a obsah
	public static void obvodAObsahObdlznika(double a, double b) {
		double obsah = a*b;
		double obvod = 2 * (a + b);
		System.out.println("Obsah obdlznika: " + obsah);
		System.out.println("Obvod obdlznika: " + obvod);
	}

//	14. Vymeni dve premenne
	public static void swap(int a, int b) {
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		int c = a;
		a = b;
		b = c;
		oddelovac();
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
//	15. Vypise obrazok tvare na konzolu
	public static void facePrint() {
		System.out.println(" +\"\"\"\"\"+                                                 \r\n"
				+ "[| o o |]                                                \r\n"
				+ " |  ^  |                                                 \r\n"
				+ " | '-' |                                                 \r\n"
				+ " +-----+");
	}
	
//	16. Scitanie binarnych cisiel
	public static void binarySum(Scanner sc) {
		String a = sc.nextLine();
		String b = sc.nextLine();
		String result = add(a, b);	
		System.out.println("Vysledok:" + result);
	}
	
	public static String add(String a, String b) {
		int b1 = Integer.parseInt(a, 2);
		int b2 = Integer.parseInt(b, 2);
		int sum = b1 + b2;
		return Integer.toBinaryString(sum);
	}
	
//	17. Nasobenie binarnych cisiel
	public static void binaryMultiplication(Scanner sc) {
		System.out.println("Zadaj prve cislo:");
		String aBin = sc.nextLine();
		System.out.println("Zadaj druhe cislo:");
		String bBin = sc.nextLine();
		
		int a = Integer.parseInt(aBin, 2);
		int b = Integer.parseInt(bBin, 2);
		
		int r = a * b;
		String rBin = Integer.toBinaryString(r);
		System.out.println("Normalny vysledok: " + r);
		System.out.println("Binarny vysledok: " + rBin);
		
	}

//  18. 
	public static void decimalToBinary(Scanner sc) {
		System.out.print("Zadaj cislo: ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("Cislo " + a + " je v binarnej podobe cislo " + Integer.toBinaryString(a));
	}

//	19.
	public static void javaInformation() {
		System.out.println("Java Version: " + System.getProperty("java.version"));
		System.out.println("Java Runtime Version: "+System.getProperty("java.runtime.version"));
		System.out.println("Java Home: "+System.getProperty("java.home"));
		System.out.println("Java Vendor: "+System.getProperty("java.vendor"));
		System.out.println("Java Vendor URL: "+System.getProperty("java.vendor.url"));
		System.out.println("Java Class Path: "+System.getProperty("java.class.path")+"\n");
	}

//	20. Porovna cisla
	public static void comparator(double a, double b) {
		if(a > b) {
			System.out.println(a + " > " + b);
		}
		else if(a < b) {
			System.out.println(a + " < " + b);
		}
		else {
			System.out.println(a + " == " + b);
		}
	}
	
//	21. Spocita sucet cislis v zadanom cisle
	public static void digitSum(int a) {
		String number = String.valueOf(a);
		int result = 0;
		for(int i = 0; i < number.length(); i++) {
			result += Character.getNumericValue(number.charAt(i));
		}
		
		System.out.println("Zadal si cislo: " + a);
		System.out.println("Sucet cislic je: " + result);
	}
	
//	22. Vypocita obsah sestuholnika
	public static void obsahHexagonu(double side) {
		double obsah = (3 * Math.sqrt(3) / 2) * side * side;
		System.out.println("Obsah hexagonu: " + obsah);
	}
	
//	23. Obrati retazec
	public static void obratString(String s) {
		String s2 = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			s2 += s.charAt(i);
		}
		
		System.out.println(s2);
	}

//  24. Vypocita pocet pismen, medzier, cisiel a inych charakterov v Stringu;
	public static void analyzaStringu(String s) {
		String[] pismena = {"a", "·", "‰", "b", "c", "Ë", "d", "Ô", "dz", "dû", "e", "È", "f", "g", "h", "ch", "i", "Ì", 
				"j", "k", "l", "Â", "æ", "m", "n", "Ú", "o", "Û", "Ù", "p", "q", "r", "‡", "s", "ö", "t", "ù", "u", "˙", "v", "w", "x", "y", "˝", "z", "û",
				"A", "¡", "ƒ", "B", "C", "»", "D", "œ", "DZ", "Dé", "E", "…", "F", "G", "H", "CH", "I", "Õ", "J", "K", "L", "≈", "º", "M", "N", "“", 
				"O", "”", "‘", "P", "Q", "R", "¿", "S", "ä", "T", "ç", "U", "⁄", "V", "W", "X", "Y", "›", "Z", "é"};
				
		String cisla = "0123456789";
		String medzera = " ";
		int pocetPismen = 0, pocetCisiel = 0, pocetMedzier = 0, ostatneZnaky = 0;
			
		
		for(int i = 0; i < s.length(); i++) {
			String aktualnyZnak = String.valueOf(s.charAt(i));
			boolean inyZnak = true;	
			
			
			for(int j = 0; j < pismena.length; j++) {				
				if(aktualnyZnak.equals(pismena[j])) {
					pocetPismen++;
					inyZnak = false;
				}
			}
			
			for(int j = 0; j < cisla.length(); j++) {
				if(aktualnyZnak.equals(String.valueOf(cisla.charAt(j)))) {
					pocetCisiel++;
					inyZnak = false;
				}
			}
			
			if(inyZnak) {
				if(aktualnyZnak.equals(medzera)) {
					pocetMedzier++;
				}
				else
					ostatneZnaky++;
			}			
		}
		
		System.out.println(s);
		System.out.println("Pocet pismen: " + pocetPismen);
		System.out.println("Pocet cisiel: " + pocetCisiel);
		System.out.println("Pocet medzier: " + pocetMedzier);
		System.out.println("Pocet ostatnych znakov: " + ostatneZnaky);				
	}
		
//	25. Z cislic 1, 2, 3, 4 vytvori vsetky mozne kombinacie cisel bez opakovania cislis a vypise pocet tychto kombinacii
	public static void threeDigitNumbers() {
		int pocetCisel = 0;
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				for(int k = 1; k <= 4; k++) {
					if(i != j && i != k && j != k) {
						System.out.printf("%d%d%d", i, j, k);
						System.out.println();
						pocetCisel++;
					}
				}
			}
		}
		System.out.println("Pocet kombinacii bez opakovania: " + pocetCisel);	}

//	26. Vypise zoznam vsetkych znakovych sad
	public static void vypisZnakoveSady() {
		System.out.println("List of available character sets: ");
		for(String str : Charset.availableCharsets().keySet()) {
			System.out.println(str);
		}
	}

//  27. Vypise ASCII hodnotu znaku
	public static void asciiHodnotaZnaku(char znak) {
		System.out.println("Ascii hodnota znaku " + znak + " je " + (int)znak);
	}

//	28. Zadaj heslo a vyis ho
	public static void heslo(Scanner sc) {
		String heslo = sc.nextLine();
		System.out.println("Tvoje heslo je: " + heslo);
	}

//  29. Zadaj int a vypise ho vo formate n + nn + nnn
	public static void trippleInt(int n) {
//		System.out.printf("%d + %d%d + %d%d%d", n, n, n, n, n, n);
	}
	
//	30. Zisti velkost suboru
	public static void velkostSuboru(String cesta) throws IOException {
		Path filePath = Paths.get(cesta);
		long fileSize = Files.size(filePath);
		
		System.out.println("Velkost suboru je: " + fileSize + " bajtov.");
	}

//	31. Zobrazi systemovy datum a cas
	public static void zobrazDatumCas() {
		java.util.Date date = new java.util.Date();
		System.out.println(date);
	}

//	32. zobraz datum a cas v specifickom formate
	public static void zobrazDatumCasVoFormate() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
		LocalDateTime date = LocalDateTime.now();
		System.out.println(format.format(date));
	}
	
//	33. Neparne cisla od x do d
	public static void neparneCisla(int zaciatok, int koniec) {
		for(int i = zaciatok; i <= koniec; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}
	}
	
//	34. zobere cislo a vypise 1 ak je parne, 0 ak je neparne
	public static void parnostNeparnost(int cislo) {
		if(cislo % 2 == 0) {
			System.out.println(cislo + ": 1");
		}
		else
			System.out.println(cislo + ": 0");
		
	}

//  35. cisla delitelne 3, 5
	public static void delitelnostTromiAPiatimi() {
		String delitelneTromi = "";
		String delitelnePiatimi = "";
		String delitelneTromiPiatimi = "";
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				delitelneTromi += i + ", ";
			}
			if(i % 5 == 0) {
				delitelnePiatimi += i + ", ";
			}
			if(i % 3 == 0 & i % 5 == 0) {
				delitelneTromiPiatimi += i + ", ";
			}
		}
		
		System.out.println("Delitelne tromi: " + delitelneTromi);
		System.out.println("Delitelne piatimi: " + delitelnePiatimi);
		System.out.println("Delitelne tromi aj piatimi: " + delitelneTromiPiatimi);
	}

//	36. String to integer
	public static void convertStringToInt(String s) {
		System.out.println(Integer.parseInt(s));
	}
	
//	37. Sucet dvoch a porovnanie s tretim prvkom
	public static void sucet(int a, int b, int c) {
		int sucet = a + b;
		System.out.println("Cislo 1: " + a);
		System.out.println("Cislo 2: " + b);
		System.out.println("Cislo 3: " + c);
		
		if(sucet == c) {
			System.out.println("Sucet a tretie cislo su rovnake");
		}
	}

//	38. Bere 3 cisla vrati true ak niektore z cisiel maju rovnaku pravu cislicu
	public static void rightDigit(int a, int b, int c) {
		String cislo = String.valueOf(a);
		String cislo2 = String.valueOf(b);
		String cislo3 = String.valueOf(c);
		
		if((cislo.charAt(cislo.length() - 1)) == (cislo2.charAt(cislo2.length() - 1))) {
			System.out.println("True");
		}
		else if((cislo2.charAt(cislo2.length() - 1)) == (cislo3.charAt(cislo3.length() - 1))) {
			System.out.println("True");
		}
		else if((cislo3.charAt(cislo3.length() - 1)) == (cislo.charAt(cislo.length() - 1))) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
	}

//	39. Berie 3 cisla a vrati true ak 3. > 2. > 1.
	public static void porovananieCisiel(int a, int b, int c) {
		if(c > b && b > a) {
			System.out.println("true");
		}
		else
			System.out.println("False");
	}
	
//	40. Prekonvertuje sekundy na hodiny, minuty a sekundy
	public static void premenSekundy() {
		long time = System.currentTimeMillis();
		
		long days = TimeUnit.MILLISECONDS.toDays(time);
		time -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(time);
		time -= TimeUnit.HOURS.toMillis(hours);
		hours += 2;
		
		long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
		time -= TimeUnit.MINUTES.toMillis(minutes);
		
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
		
		System.out.println(hours + ":" + minutes + ":" + seconds);
		
		
	}

//	41. Zobere dve hodnoty reprezentujuce rozsah prvkov a cislo, ktorym sa hodnoty budu delit, vrati mnozstvo prvkov daneho rozsahu, ktore su delitelne cislom delenia
	public static void rozsahHodnot(int start, int end, int delitel) {
		int pocetCisiel = 0;
		for(int i = start; i <= end; i++) {
			if(i % delitel == 0) {
				pocetCisiel++;
			}
		}
		
		System.out.println("Pocet cisiel v rozsahu: " + pocetCisiel);
	}

//	42. delitel cisla
	public static void delitelCisla(int number) {
		int pocetDelitelov = 0;
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) {
				pocetDelitelov++;
			}
		}
		System.out.println(pocetDelitelov);
	}
	
}

