import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> zoznamMien = new ArrayList<>();
		zoznamMien.add("Karol");
		zoznamMien.add("Peter");
		zoznamMien.add("Anna");
		
		List<Integer> cisla = new ArrayList<>();
		cisla.add(10);
		cisla.add(150);
		cisla.add(1);
		cisla.add(-150);
		cisla.add(9);
		
		List<String> zoznamPriezvisiek = new ArrayList<>();
		zoznamPriezvisiek.add("Sauer");
		zoznamPriezvisiek.add("Pernik");
		zoznamPriezvisiek.add("Novotný");
		
//		1. Vytvori list a vypise polozky listu (mena)
//		vypisMenaZListu("Lukáš", "Marek", "Lenka", "Lucia", "Filip");

//		2. Vlozi element na prve miesto do zoznamu mien
//		vlozMenoNaPrveMiesto(zoznamMien, "Lukáš");

// 		3. Nahradi prvok na druhej pozicii
//		vypisObsahListu(zoznamMien);
//		nahradMeno(zoznamMien, "Lukáš");
//		vypisObsahListu(zoznamMien);
		
//		4. Zisti, ci sa dany prvok nachadza v liste
		System.out.println(vyhladajPrvok(zoznamMien, "Anna"));
		
//		5. Spracuje vratenu hodnotu
//		int prvok = vyhladajPrvok(zoznamMien, "Karol");
//		if(prvok != -1) {
//			System.out.println(zoznamMien.get(prvok));
//		}else {
//			System.out.println("Meno sa nenaslo!");
//		}
		
//		6. Zotriedenie kolekcie
//		zoznamMien.sort(null);
//		vypisObsahListu(zoznamMien);
//		cisla.sort(null);
//		vypisObsahListuCisla(cisla);
		
//		7. Prida elementy z jednej kolekcie na koniec druhej kolekcie
//		zoznamMien.addAll(zoznamPriezvisiek);
//		System.out.println(zoznamMien);
		
//		8. Vymeni 2 elementy v kolekcii medzi sebou
//		System.out.println(zoznamMien);
//		Collections.swap(zoznamMien, 0, 2);
//		System.out.println(zoznamMien);
		
//		9. Zisti ci dana kolekcia je prazdna
		if(zoznamMien.isEmpty())
			System.out.println("Kolekcia je prazdna");
		else
			System.out.println("Kolekcia nie je prazdna");
		
//		10. Vypise elementy na konzolu pomocou indexu/for
		for(int i = 0; i < zoznamMien.size(); i++) {
			System.out.println(zoznamMien.get(i));
		}
		
//		11. HashMap, prida zopar zaznamov a vypise ich
		Map<Integer, Osoba> osoby = new HashMap();
		osoby.put(1, new Osoba("Lukáš", "Sauer", 22));
		osoby.put(3, new Osoba("Lenka", "Sauerová", 47));
		osoby.put(8, new Osoba("Marek", "Sauer", 48));
		osoby.put(2, new Osoba("Filip", "Sauer", 15));
		osoby.put(5, new Osoba("Lucia", "Sauerová", 17));
//		
//		for(Map.Entry m : osoby.entrySet()) {
//			System.out.println(m.getValue());
//		}
//		12.  
//		System.out.println(osoby.containsKey(1));
//		
//		Map<Integer, String> prstene = new HashMap();
//		prstene.put(1, "Strieborny prsten");
//		prstene.put(2, "Zlaty prsten");
//		prstene.put(3, "Bronzovy prsten");
//		
//		for(Map.Entry m : prstene.entrySet()) {
//			System.out.println(m.getValue());
//		}

//		13. Vlozi kolekciu osob do ArrayListu.
//		List<Osoba> listOsob = new ArrayList<>();
//		for(Map.Entry m : osoby.entrySet()) {
//			listOsob.add((Osoba)m.getValue());
//		}
//		
//		System.out.println(listOsob);
		
//		14. Nacita riadky z textoveho suboru a ulozi ich do kolekcie - 1 riadok, jeden zaznam
		List<String> osobyZoSuboru = new ArrayList<>(); 
		String cesta = "C:\\Users\\lsaue\\Dropbox\\Programovanie\\Java - 2022\\Kolekcie - ulohy\\src\\osoby.txt";
		nacitajSuborDoKolekcie(osobyZoSuboru, cesta);
		for(String s : osobyZoSuboru) {
			System.out.println(s);
		}
		
		Set<String> set = new HashSet<>();
		set.add("Cislo 1");
		set.add("Cislo 2");
		set.add("Cislo 3");
		
		vypisKolekciu(zoznamMien);
		vypisKolekciu(set);
	}
	
	public static void vypisObsahListu(List<String> cisla) {
		for(String meno : cisla) {
			System.out.println(meno);
		}
	}
	
	public static void vypisObsahListuCisla(List<Integer> zoznamMien) {
		for(Integer n : zoznamMien) {
			System.out.println(n);
		}
	}
	
	
//	1. Vytvori list a vypise polozky listu (mena)
	public static void vypisMenaZListu(String... mena) {
		List<String> zoznamMien = new ArrayList<>();
		
		for(String meno : mena) {
			zoznamMien.add(meno);
		}
		
		for(String meno : zoznamMien) {
			System.out.println(meno);
		}
	}
	
//	2. Vlozi element na prve miesto v zozname mien
	public static void vlozMenoNaPrveMiesto(List<String> zoznamMien, String meno) {
		zoznamMien.add(0, meno);
		for(String m : zoznamMien) {
			System.out.println(m);
		}
	}
	
//	3. Nahradenie mena na druhej pozicii v liste
	public static void nahradMeno(List<String> zoznamMien, String meno) {
		zoznamMien.remove(1);
		zoznamMien.add(1, meno);
	}
	
//  4. Zisti, ci sa dany prvok nachadza v liste
	public static int vyhladajPrvok(List<String> zoznamMien, String hladaneMeno) {
		if(zoznamMien.contains(hladaneMeno)) {
			for(int i = 0; i < zoznamMien.size(); i++) {
				if(zoznamMien.get(i).equals(hladaneMeno)) {
					return i;
				}				
			}
		}
		return -1;
	}

//	14. Nacita riadky z textoveho suboru a ulozi ich do kolekcie - 1 riadok, jeden zaznam, metoda precita subor a nacita ich do kolekcie
	public static void nacitajSuborDoKolekcie(List<String> osoby, String cesta) throws IOException {
		BufferedReader inputStream = null;		
		try {
			inputStream = new BufferedReader(new FileReader(cesta));
			
			String s;
			while ((s = inputStream.readLine()) != null) {
				osoby.add(s);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

//  15. Vypise kolekciu
	public static void vypisKolekciu(Collection<String> kolekcia) {
		for(String s : kolekcia) {
			System.out.println(s);
		}
	}

}


