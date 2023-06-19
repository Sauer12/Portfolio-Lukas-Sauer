import kniznica.*;

public class Main {

	public static void main(String[] args) {
		
		GenerickaTrieda<String> trieda = new GenerickaTrieda<>();
		trieda.pridajObjekt("Ahoj, som genericka Trieda");
		System.out.println(trieda.vratObjekt());
		
		GenerickaTrieda<Integer> trieda2 = new GenerickaTrieda<>();
		trieda2.pridajObjekt(666);
		System.out.println(trieda2.vratObjekt());
		
		GenerickaTrieda<Auto> trieda3 = new GenerickaTrieda<>();
		trieda3.pridajObjekt(new Auto("Mercedes", 100000, 35000));
		System.out.println(trieda3.vratObjekt());
		
		GenerickaTrieda2<String, Integer> trieda4 = new GenerickaTrieda2<>();
		trieda4.pridajObjekty("Text", 123);
		System.out.println(trieda4.vratObjekt1());
		System.out.println(trieda4.vratObjetk2());
		
		GenerickaTrieda3<Integer, String, Auto> trieda5 = new GenerickaTrieda3<>();
		trieda5.pridajObjekty(150, "Lukáš", new Auto("Skoda", 10000, 8500));
		System.out.println(trieda5.getObjekt1());
		System.out.println(trieda5.getObjekt2());
		System.out.println(trieda5.getObjekt3());
		
		System.out.println();
		
		Film film = new Film("Titanic");
		CD cd = new CD("Viktor Sheen - Cernobilej svet");
		Kniha kniha = new Kniha("Makroekonomia");
		Kniznica kniznica = new Kniznica();
		kniznica.pridajMedium(film);
		kniznica.pridajMedium(cd);
		kniznica.pridajMedium(kniha);
		
		kniznica.vypisMedia();
		
		System.out.println();
		
		GenerickeMedium<Film> generickyFilm = new GenerickeMedium<>(new Film("Black Mirror"));
		GenerickeMedium<Kniha> generickaKniha = new GenerickeMedium<>(new Kniha("Harry Potter"));
		GenerickeMedium<CD> generickeCD = new GenerickeMedium<>(new CD("Separ"));
		
		GenerickaKniznica generickaKniznica = new GenerickaKniznica<>();
		generickaKniznica.pridaj(generickyFilm);
		generickaKniznica.pridaj(generickaKniha);
		generickaKniznica.pridaj(generickeCD);
		
		generickaKniznica.vypisPolozky();
	}

}
