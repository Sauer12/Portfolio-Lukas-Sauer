
public class Main {
	
	public static void main(String[] args){
		try {
			metoda();			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void overCislo(int cislo) throws NumberException{
		if(cislo > 10) {
			throw new NumberException("Cislo je vacsie ako 10 - chyba!");
		}
		else
			System.out.println("Cislo je mensie ako desat");
	}
	
	public static void delenie(int a, int b) throws DelenieException{
		if(b == 0) {
			throw new DelenieException("Snazis sa delit cislom 0 - chyba!");
		}
		else
			System.out.println(a/b);
	}
	
	public static void metoda() throws NumberException{
		overCislo(11);
		delenie(5,0);
	}
	
}
