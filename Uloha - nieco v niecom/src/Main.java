
public class Main {
	
	public static void main(String[] args) {
		tvarUpToDown(4);
		tvarDownToUp(10);
	}
	
	
	static void tvarUpToDown(int cislo) {
		for(int i = 0; i < cislo; i++) {
			for(int j = i; j < cislo; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void tvarDownToUp(int cislo) {
		for(int i = cislo; i > 0; i-- ) {
			for(int j = cislo; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
