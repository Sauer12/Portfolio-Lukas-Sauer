package sk.lukas.sauer;

public class Main {
	
	public static void main(String[] args) {
		Dvere dvere = new Dvere("Biela", "Drevo");
		Skrina skrina = new Skrina("Hneda", "Drevo");
		Obraz obraz = new Obraz();
		Gauc gauc = new Gauc("Biela", "Koza");
		
		
		System.out.println(dvere);
		dvere.otvor();
		System.out.println(skrina);
		skrina.zatvor();
		System.out.println(obraz);
		obraz.zavesit();
		System.out.println(gauc);
		gauc.sadnut();
	}
}
