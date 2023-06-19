
public class Main {

	public static void main(String[] args) {
		vynasob(10);
		vynasob(10.532626951515);
	}
	
	public static void vynasob(Number cislo) {
		if(cislo instanceof Integer) {
			System.out.println(cislo.intValue() * 10);
		}
		else if(cislo instanceof Double) {
			System.out.println(cislo.doubleValue() * 10);
		}
		else
			System.out.println("Cislo sa nepodarilo pretypovat");
	}

}
