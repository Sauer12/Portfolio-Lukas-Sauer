
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Zadaj meno osoby: ");
//		String meno = sc.nextLine();
//		System.out.print("Zadaj priezvisko osoby: ");
//		String priezvisko = sc.nextLine();
//		Osoba osoba = new Osoba(meno, priezvisko);
//		System.out.println(osoba);
//		System.out.print("Zadaj cislo: ");
//		zadajCislo(sc.nextLine());
		
//		easyCalculator(sc);
		
//		citajData();
		
//		LocalTime casNastupu = LocalTime.now();
//		odchodZPrace(casNastupu);
//		odchodZPrace(casNastupu, 6);
		
//		LocalDate narodeniny = LocalDate.of(2000, 2, 1);
//		narodeniny(narodeniny, 5);
		
		sviatky(LocalDate.of(2022, 4, 15));
		sviatky(LocalDate.of(2022, 2, 1));
		sviatky(LocalDate.of(2022, 12, 24));
		sviatky(LocalDate.of(2022, 8, 29));
		
		
	}
	
// 1. Umoznuje zadavat data ako vstup, ak stlacis q, metoda skonci
	public static void citajData() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Zadaj nieco: ");
			String input = sc.nextLine();
			
			if("q".equals(input)) {
				System.out.println("Exit");
				break;
			}
			
			
			System.out.println("Input: " + input);
			System.out.println("-----------\n");
		}		
		sc.close();
	}
	
// 3. Uzivatel zada cislo, ak napise nieco ine ako cislo, vypise sa chybova hlaska
	public static void zadajCislo(String input) {
		int cislo = 0;
		if(input.matches("[0-9]+")) {

			System.out.println("Zadal si cislo " + cislo);
		}
		else
			System.out.println("Nezadal si cislo.");
			
	}

// 4. Uzivatel zada matematicku operaciu a 2 cisla, metoda na zaklade toho spravi prislusnu matematicku operaciu
	public static void easyCalculator(Scanner sc) {
		System.out.print("Zadaj prve cislo: ");
		int cislo1 = Integer.parseInt(sc.nextLine());	
		System.out.print("Zadaj druhe cislo: ");
		int cislo2 = Integer.parseInt(sc.nextLine());			
		
			
		System.out.print("Zvol matematicku operaciu: ");
		String operacia = sc.nextLine();
		
		switch(operacia) {
		case "+":
			System.out.println(cislo1 + cislo2);
			break;
		case "-":
			System.out.println(cislo1 - cislo2);
			break;
		case "*":
			System.out.println(cislo1 * cislo2);
			break;
		case "/":
			if(cislo2 == 0) {
				System.out.println("Nemozem delit nulou.");
				break;
			}
			System.out.println(cislo1/cislo2);
			break;
		default:
			System.out.println("Neplatna operacia");
		}
	}
	
// 5. Na vstupe bere cas nastupu do prace a na zaklade toho vypise, kedy moze clovek odist z prace
	public static void odchodZPrace(LocalTime casNastupu) {
		System.out.println("Cas nastupu do prace: " + casNastupu.getHour() + ":" + casNastupu.getMinute());
		LocalTime odchod = casNastupu.plusHours(8);
		System.out.println("Z prace mozes odist: " + odchod.getHour() + ":" + casNastupu.getMinute());
	}

// 6. to iste ako 5. avsak metoda ma druhy parameter, ktory prezentuje dlzku pracovnej doby
	public static void odchodZPrace(LocalTime casNastupu, int dlzka) {
		System.out.println("Cas nastupu do prace: " + casNastupu.getHour() + ":" + casNastupu.getMinute());
		LocalTime odchod = casNastupu.plusHours(dlzka);
		System.out.println("Z prace mozes odist: " + odchod.getHour() + ":" + casNastupu.getMinute());
	}

// 7. Metoda bere datum narodenia a vypise v ake dni v buducnosti budes mat narodeniny
	public static void narodeniny(LocalDate narodeniny, int pocetRokov) {
		narodeniny = narodeniny.plusYears(LocalDate.now().getYear() - narodeniny.getYear());
		for(int i = 0; i < pocetRokov; i++) {
			System.out.println("V roku " + narodeniny.plusYears(i) + " budes mat narodeniny v dni: " + narodeniny.plusYears(i).getDayOfWeek());
		}
	}

// 8. Metoda vypise, ci je dnes prave sviatok
	public static void sviatky(LocalDate den) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		
		LocalDate[] sviatky = {LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 6), LocalDate.of(2022, 4, 15),
								LocalDate.of(2022, 4, 18), LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 8),
								LocalDate.of(2022, 7, 5), LocalDate.of(2022, 8, 29), LocalDate.of(2022, 9, 1),
								LocalDate.of(2022, 9, 15), LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 17),
								LocalDate.of(2022, 12, 24), LocalDate.of(2022, 12, 25), LocalDate.of(2022, 12, 26)};
		
		System.out.println("Dnesny den: " + formatter.format(den));
		
		for(LocalDate sviatok : sviatky) {
			if(sviatok.equals(den)) {
				System.out.println("Dnes je sviatok");
			}
		}
	}

}