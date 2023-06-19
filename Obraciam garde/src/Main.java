
public class Main {
	
	public static void main(String[] args) {
		System.out.println(obratenyString("Lukáš Sauer"));
		System.out.println(obratenyString("Malý medveï"));
		System.out.println(obratenyString("Jaroslav Beòo"));
	}
	
	public static char[] obratenyString(String slovo) {
		String slovo1 = "";
		String slovo2 = "";
		String pomocnaPremenna = "";
		boolean medzera = true;
		
		for(char c : slovo.toCharArray()) {
			if(c == ' ') {
				medzera = false;
				continue;
			}
			if(medzera)
				slovo1 += c;
			else
				slovo2 += c;
		}
		
		if(!slovo1.equals("")) {
			for(int i = slovo1.length() - 1; i >= 0; i--) {
				pomocnaPremenna += slovo.toCharArray()[i];
			}
			slovo1 = pomocnaPremenna;
			pomocnaPremenna = "";
		}
		if(!slovo2.equals("")) {
			for(int i = slovo2.length() - 1; i >= 0; i--) {
				pomocnaPremenna += slovo2.toCharArray()[i];
			}
			slovo2 = pomocnaPremenna;
		}
		
		return (slovo1 + " " + slovo2).toCharArray();
	}
	
}
