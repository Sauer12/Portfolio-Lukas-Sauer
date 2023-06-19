import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
//		Premenne a ich inicializacia
		String cesta = "C:\\Users\\lsaue\\Dropbox\\Programovanie\\Java - 2022\\Lucia - Uloha\\src\\bus_vytazenost.txt";
		FileReader inputStream = null; 
		String subor = "";
		String zastavky = "";
		String zastavkySPrekrocenouKapacitou = "";
		int pocetZastavok = 0;
		int maximalnaKapacita = 0;
		int kapacita = 0;
		int max = 0;
		List<Integer> pocetLudi = new ArrayList<Integer>(); //Toto sa da nahradit polom
		
		
//		Citanie suboru po znakoch, kazdy znak sa ulozi do premennej (String)subor
		try {
			inputStream = new FileReader(cesta);
			
			int c;
			while((c = inputStream.read()) != -1) {
				//ukladanie znaku do (String)subor
				subor += (char) c;
			}
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
		
//		rozdeli retazec subor na podretazce(samostatne riadky) na zaklade "\n".
		String[] riadkySuboru = subor.split("\n");
		
		
		subor = subor.replaceAll("\n", "").replaceAll("\r", " ");	
		
//		zobere prvy riadok (cislo s max kapacitou) a vymaze v tomto riadku vsetky nove riadky, 
//		aby sa dalo toto cislo nacitat do Integer (maximalna premenna) a mohol s nim pracovat
		riadkySuboru[0] = riadkySuboru[0].replaceAll("\n", "").replaceAll("\r", "");
		maximalnaKapacita = Integer.parseInt(riadkySuboru[0]);
		
//		Deklaracia pola, ktore bude obsahovat jednotlive slova riadku
		String[] jednotliveSlova;
		
//		cyklus, ktory sa spravy tolko krat, kolko mame riadkov
		for(int i = 0; i < riadkySuboru.length; i++) {
//			kazdy riadok sa rozdeli na slova a tieto slova v danom riadku sa ulozia do jednotliveSlova 
//			napr. -> 20 0 Štúrovo nám. = 1. (20), 2. (0), 3. (Štúrovo), 4. (nám.)
			 jednotliveSlova = riadkySuboru[i].split(" ");
//			ak sa nenachadzame na prvom riadku, tak zvysim stale pocetZastavok o 1;
			 if(i > 0) {
				 pocetZastavok++;
			 }		
			 
//			 ak nie sme na prvom riadku
			 if(i != 0) {
//				 cyklus v cykle, preiterujeme jednotlive slova 
				 for(int j = 0; j < jednotliveSlova.length; j++) {
//					 v kazdom slove odstranime "\n" a "\r", aby sme ich vedeli parsovat a prenasat na cisla
					 jednotliveSlova[j] = jednotliveSlova[j].replaceAll("\n", "").replaceAll("\r", "");
//					 ak sme na prvom slove, tak kapacitu zvysime o dany pocet
					 if(j == 0) {
						 kapacita += Integer.parseInt(jednotliveSlova[j]);
					 }			 
//					 ak sme na druhom slove, kapacitu zase znizime o dany pocet
					 if(j == 1) {
						 kapacita -= Integer.parseInt(jednotliveSlova[j]);
					 }
					 
//					 ak sme na tretom alebo dalsiom slove (nie poslednom), tak do premennej zastavky pridame dane slovo a " "
					 if(j > 1 && j != jednotliveSlova.length - 1) {
						 zastavky += jednotliveSlova[j] + " ";
//						 ak sme prekrocili maximalnu kapacitu, tak pridame do premennej zastavkySPrekrocenouKapacitou zastavku, na ktorej bol prekroceny limit
						 if(kapacita > maximalnaKapacita) {
							 zastavkySPrekrocenouKapacitou += jednotliveSlova[j] + " "; 
						 }
					 }
//					 da sa aj zapisat inac, ale tato podmienka hovori, ze ak sa nachadzame na poslednom slove
//					 robi to iste ako blok kodu hore, akurat miesto " " pridava ", "
					 else if(j > 1) {
						 zastavky += jednotliveSlova[j] + ", ";
						 if(kapacita > maximalnaKapacita) {
							 zastavkySPrekrocenouKapacitou += jednotliveSlova[j] + ", "; 
						 }
					 }
				 }
				 
//				 prida aktualnu kapacitu na danej zastavke do Listu(ty mozes pouzit pole)
				 pocetLudi.add(kapacita);
			 }			 
		}
		
		//tento kod spravi len to, ze sa vymaze ciarka za poslednym slovom
		zastavky = zastavky.substring(0, zastavky.length() - 2);
		zastavkySPrekrocenouKapacitou = zastavkySPrekrocenouKapacitou.substring(0, zastavkySPrekrocenouKapacitou.length() - 2);
		
		//Vypisanie toho, co treba
		System.out.println("Poèet zastávok autobusu: " + pocetZastavok);
		System.out.println("Zastávky autobusu: " + zastavky);
		System.out.println("Zastávky s prekroèenou maximálnou kapacitou: " + zastavkySPrekrocenouKapacitou);
		
		//Vlozenie najvacsie kapacity ludi v autobuse do premennej max
		for(int i : pocetLudi) {
			if(i > maximalnaKapacita && i > max) {
				max = i;
			}
		}
		
		//ak bola niekedy kapacita(max) vacsie ako maximalnaKapacita, vypise sa kolko ludi bolo nad ramec kapacity, inac nie
		if(max > maximalnaKapacita) {
			System.out.println("Najvyšší poèet ¾udí nad ramec kapacity: " + (max - maximalnaKapacita));			
		}
		else
			System.out.println("Nebol prekroèený poèet ¾udí nad ramec kapacity");
		
		

	}
}
