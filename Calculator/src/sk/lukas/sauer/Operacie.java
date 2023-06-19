package sk.lukas.sauer;

public class Operacie {

	
	public static void scitaj(int cislo1, int cislo2) {
		System.out.println(cislo1 + cislo2);
	}
	
	public static void odcitaj(int cislo1, int cislo2) {
		System.out.println(cislo1 - cislo2);
	}
	
	public static void vynasob(int cislo1, int cislo2) {
		System.out.println(cislo1 * cislo2);
	}
	
	public static void vydel(int cislo1, int cislo2) {
		if(cislo2 == 0)
			System.out.println("Nemozem delit nulou!");
		else
			System.out.println(cislo1 / cislo2);
	}
}
