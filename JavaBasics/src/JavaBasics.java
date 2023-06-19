
public class JavaBasics {
	
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		int k;
		
		if(j > i) {
			System.out.println(j);
		}
		else {
			System.out.println(i);
		}
		
		int ternarnyOperator = (i > j) ? i : j;
		System.out.println(ternarnyOperator);
		
		while(i == 1) {
			System.out.println("Cyklus sa spravil.");
			i++;
		}
		
		do {
			System.out.println("Do-while cyklus");
		}while(i == 1);
		
		for(k = 0; k < 10; k++) {
			System.out.println("Ahoj + " + k);
		}
		
		System.out.println(k);
		
		if(k == 10) {
			if(k == 10) {
				System.out.println(k);
			}
		}
		
	}
	
}
