
public class Main {
	
	public static void main(String[] args) {		
		System.out.println(vyskytSlovaVTexte("Veta ahoj mojko ahoj ahj", "ahoj"));
	}
	
	public static int vyskytSlovaVTexte(String text, String slovo) {
		int vyskytSlova = 0;
		int j = 0;
		
		for(int i = 0; i < text.length(); i++) {
			
			if(text.toCharArray()[i] == slovo.toCharArray()[j])
				j++;
			else
				j = 0;
			
			if(j == slovo.length()) {
				vyskytSlova++;
				j = 0;
			}
		}		
		
		return vyskytSlova;
	}
}
