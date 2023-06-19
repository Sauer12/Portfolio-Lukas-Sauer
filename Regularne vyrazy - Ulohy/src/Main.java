import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		overEmail("lsauercv12@gmail.com");	
		overEmail("lukisauer@gmail.com");
		overEmail("css@gmail.com");
		
		overHeslo("NeviemM123");
		
		overObrazok("Obrazok.jpg");
		overObrazok("Obrazok.png");
		overObrazok("Obrazok.jpeg");
		overObrazok("Obrazok.bmp");
		overObrazok("Obrazok.xpx");
		
		overDatum("01.02.2000");
		overDatum("41.12.2000");
		overDatum("11.11.3000");
		overDatum("01.15.2000");
		
		vypisSlovaSVelkymP("Ahoj volam sa Lukas Sauer a byvam v Malej Ide");
		najdiCisla("Ahoj, narodilm som sa 1.2.2000 a mam 22 rokov. Do skoly som chodil 13 rokov");
	}
	
//	1. Overi, ci je email v spravnom formate a vrati TRUE alebo FALSE
	public static void overEmail(String email) {
		String regex = "\\w{5,}@gmail\\.com";
		
		System.out.println(email.matches(regex));		
	}
	
//	2. Overi heslo, ktore musi mat minimalne 8 znakov, musi obsahovat 1 velke pismeno a aspon 1 cislicu. -PREROBIT
	public static void overHeslo(String heslo) {
		String regex = "\\w{6,}[A-Z]+[0-9]+";		
		System.out.println(heslo.matches(regex));
	}
	
//  3. Overi, ci dany String je obrazok vo formate .jpg, .png, .jpeg, .bmp
	public static void overObrazok(String obrazok) {
		 String regexJpg = "\\w{1,}[.](jpg)";
		 String regexPng = "\\w{1,}[.](png)";
		 String regexJpeg = "\\w{1,}[.](jpeg)";
		 String regexBpm = "\\w{1,}[.](bmp)";
		 
		 if(obrazok.matches(regexJpg))
			 System.out.println("Obrazok je vo formate .jpg");
		 else if(obrazok.matches(regexPng))
			 System.out.println("Obrazok je vo formate .png");
		 else if(obrazok.matches(regexJpeg))
			 System.out.println("Obrazok je vo formate .jpeg");
		 else if(obrazok.matches(regexBpm))
			 System.out.println("Obrazok je vo formate .bmp");
		 else
			 System.out.println("Obrazok je v nespravnom formate.");
	}
	
// 4. Overi, ci dany String je v spravnom formate datumu (dd/mm/yyyy)
	public static void overDatum(String datum) {
		String regex = "[0-3][0-9][.][0-1][0-9][.][0-9][0-9][0-9][0-9]";
		System.out.println(datum.matches(regex));
	}
	
// 5. Vypise vsetky slova zacinajuce na velke pismenov texte
	public static void vypisSlovaSVelkymP(String text) {
		String regex = "\\b[A-Z]\\w+\\b";
		displayResults(regex, text);
	}
	
//	6. Najde vsetky cisla v texte a vypise ich na konzolu
	public static void najdiCisla(String text) {
		String regex = "[0-9]";
		displayResults(regex, text);
	}
	
	public static void displayResults(String pattern, String text) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		
		boolean found = false;
		
		while (m.find()) {
			System.out.println("Nasiel som text: " + m.group());
			System.out.println("zaciatok: " + m.start());
			System.out.println("koniec: " + m.end());
			System.out.println("_____________");
			found = true;
		}
		
		if (!found) {
			System.out.println("Nic som nenasiel");
			System.out.println("_____________");
		}
	}

}
