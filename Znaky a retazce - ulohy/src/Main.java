import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String text = "Petra boli noha!";
		String text2 = "Nejaky dlhy text, blablabla ahoj 65185183, volam sa Lukas Sauer.";
		String text3 = "Ahoj, volam sa LuKaS Sauer. a toto, je sKUSObny Test.";
		
		System.out.println(text.length());
		System.out.println(text.charAt(12));
		System.out.println(text.charAt(11));
		
		text = "Dnes budem studovat javu";
		
		System.out.println(text.substring(9, 12));
		
		transformujNaMale("aHOj voLAm Sa KarOl");
		nahrad(text);
		odrezCiarku("Jarko sa hrá s pieskom, lopatkou, kladivkom a je mu fajn.");
		textMedziCiarkami("Jarko sa hrá s pieskom, lopatkou kladivkom, a je mu fajn.");
		System.out.println();
		System.out.println(text3);
		analyzaTextu(text3);
		System.out.println();
		System.out.println(text3);
		prerobText(text3);
		System.out.println();
		inicialka("Frantisek Ferdinand Velky");
		System.out.println();
		htmlText("[header]Ac mi[/header] massa ac [code]praesent eget[/code], "
				+ "aliquam egestas suscipit, potenti massa, porttitor [link:www.learn2code.sk] "
				+ "gravida quis ac velit facilisi[/link], imperdiet massa rhoncus felis arcu. "
				+ "Ut nullam, mauris vitae, ligula quisque est.");
	}
	
//1. Zobere retazec a transformuje ho na male pismena avsak posledne 2 pismena transformuje na velke pismena
	public static void transformujNaMale(String text) {
		String pomocna = text.substring(text.length() - 2, text.length()).toUpperCase();
		System.out.println(text.substring(0, text.length() - 2).toLowerCase() + pomocna);
	}
	
//2. Nahradi vsetky pismena 'a' v retazci za '@' 	
	public static void nahrad(String text) {
		System.out.println(text.replace('a', '@'));
	}
	
//3. Odreze text za poslednou ciarkou
	public static void odrezCiarku(String text) {
		System.out.println(text.substring(0, text.lastIndexOf(",")));
	}
	
//4.  Vymaze text medzi prvou ciarkou a druhou ciarkou
	public static void textMedziCiarkami(String text) {
		char znak = ',';
		int poradie = 1;
		int prvaCiarka = 0;
		int druhaCiarka = 0;
		for(int i = 0; i < text.length() - 1; i++) {
			if(znak == text.toCharArray()[i] && poradie == 1) {
				prvaCiarka = i;
				poradie++;
			}
			else if(znak == text.toCharArray()[i] && poradie == 2) {
				druhaCiarka = i;
				poradie++;
			}
		}		
		System.out.println(text.substring(0, prvaCiarka) + text.substring(druhaCiarka + 1));
	}
	
//5. Analyzuje text
	public static void analyzaTextu(String text) {
		int slovo = 0;
		int pocetSlov = 0;
		int pocetZnakov = 0;
		int pocetPrazdnychZnakov = 0;
		int pocetCisiel = 0;
		int pocetBodiek = 0;
		int pocetCiarok = 0;
		int pocetSlovNaVelkePismeno = 0;
		String velkePismena = "ABCDEFGHIJKLMNOPQRSTVUWXYZ";
		String znaky = "abcdefghijklmnopqrstvuwxyzABCDEFGHIJKLMNOPQRSTVUWYXZ";
		String cisla = "1234567890";
		
		for(int i = 0; i < text.length(); i++) {
			for(int j = 0; j < znaky.length(); j++) {
				if(znaky.toCharArray()[j] == text.toCharArray()[i]) {
					pocetZnakov++;					
					slovo++;
				}			
			}	
			for(int j = 0; j < cisla.length(); j++) {
				if(cisla.toCharArray()[j] == text.toCharArray()[i]) {
					pocetCisiel++;					
					slovo++;
				}			
			}
			
			for(int j = 0; j < velkePismena.length(); j++) {
				if(velkePismena.toCharArray()[j] == text.toCharArray()[i]) {
					if(i - 1 >= 0) {
						if((text.toCharArray()[i - 1] == ' ') || (text.toCharArray()[i - 1] == ',')) {
							pocetSlovNaVelkePismeno++;
						}
					}	
					else{
						pocetSlovNaVelkePismeno++;
					}
				}
			}			
			
			if(text.toCharArray()[i] == ' ') {
				pocetPrazdnychZnakov++;
				if(slovo != 0) {
					slovo = 0;
					pocetSlov++;
				}
			}
			else if(text.toCharArray()[i] == ',') {
				pocetCiarok++;
				if(slovo != 0) {
					slovo = 0;
					pocetSlov++;
				}
			}
			else if(text.toCharArray()[i] == '.') {
				pocetBodiek++;
				if(slovo != 0) {
					slovo = 0;
					pocetSlov++;
				}
			}
		}
		
		System.out.println("Pocet slov na velke pismeno: " + pocetSlovNaVelkePismeno);
		System.out.println("Pocet slov: " + pocetSlov);
		System.out.println("Pocet znakov: " + pocetZnakov);
		System.out.println("Pocet prazdnych znakov: " + pocetPrazdnychZnakov);
		System.out.println("Pocet bodiek: " + pocetBodiek);
		System.out.println("Pocet ciarok: " + pocetCiarok);
		System.out.println("Pocet cisiel: " + pocetCisiel);
	}

//6. Vymaze bodky, ciarky a kazde druhe pismeno prerobi na velke
	public static void prerobText(String text) {
		
		String malePismena = "abcdefghijklmnopqrstvuwxyz";
		String velkePismena = "ABCDEFGHIJKLMNOPQRSTVUWXYZ";
		
		char[] myText = text.toCharArray();
		
		for(int i = 0; i < text.length(); i = i+2) {
			for(int j = 0; j < malePismena.length(); j++) {
				if(text.toCharArray()[i] == malePismena.toCharArray()[j]) 
					myText[i] = velkePismena.toCharArray()[j];				
			}
		}			
		
		text = String.valueOf(myText);	
		text = text.replaceAll(",", "");
		text = text.replaceAll("\\.", "");
		System.out.println(text);
	}
	
//7. Zobere na vstupe meno z ktoreho vytvori inicialku bez bodky za poslednym menom/priezviskom
	public static void inicialka(String meno) {

		
		
		String pomocna = "";
		String inicialka = "";
		String[] slova = new String[10];
		int slovaPoradie = 0;
		String pismena = "abcdefghijklmnopqrstvuwxyzABCDEFGHIJKLMNOPQRSTVUWXYZ";
		
		for(int i = 0; i < meno.length(); i++) {
			for(int j = 0; j < pismena.length(); j++) {				
				if(pismena.toCharArray()[j] == meno.toCharArray()[i]) {
					pomocna += meno.toCharArray()[i];
				}
			}		
			if(meno.toCharArray()[i] == ' ' || i == meno.length() - 1) {
				slova[slovaPoradie] = pomocna;
				slovaPoradie++;
				pomocna = "";
			}			
		}
		
		for(int i = 0; i < slova.length; i++) {
			if(slova[i] != null) {
				pomocna = slova[i].toUpperCase();
				inicialka += pomocna.substring(0, 1) + ".";
			}
		}
		
		inicialka = inicialka.substring(0,inicialka.length()-1);
	
		System.out.println(inicialka);
	}

//8.
	public static void htmlText(String text) {
		text = text.replaceAll("\\[/code\\]", "</code>").replaceAll("\\[header\\]", "<h1>").
		replaceAll("\\[/header\\]", "</h1>").replaceAll("\\[link:www.learn2code.sk\\]", "<a href = \"www.learn2code.sk\">").
		replaceAll("\\[/link\\]", "</a>").replaceAll("\\[code\\]", "<code>");
		
		System.out.println(text);
	}

}


