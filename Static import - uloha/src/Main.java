
import static java.lang.Math.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(zaokruhli(5.125616));
	}
	
	public static double zaokruhli(double cislo) {
		return ceil(cislo);
	}

}
