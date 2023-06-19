
public class Main {
	
	public static void main(String[] args) {
		System.out.println(sum(7));
		System.out.println(sum(10));
		System.out.println(sum(40));
	}
	
	
	public static int sum(int number) {
	    if (!(number % 5 == 0) && !(number % 7 == 0)){
	      return number + sum(number - 1);
	    }
	    else if (number > 0) {
	      return sum(number - 1);
	    }
	    else
	      return number;      
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	void sucet(int number1, int number2) {
		System.out.println(number1 + number2);
	}
	
	void sucet(int number1, int number2, int number3) {
		System.out.println(number1 + number2 + number3);
	}
	
	int sucetVrat(int number1, int number2) {
		return number1 + number2;
	}
	
	int sucetVrat(int number1, int number2, int number3) {
		return number1 + number2 + number3;
	}
	
	int suma(int number) {
		if(number > 0) {
			return number + suma(number - 1);
		}
		else
			return 0;
	}
	
	
	int fib(int number) {
		if(number <= 1) {
			return number;
		}
		return fib(number - 1) + fib(number - 2);
	}
	
	
	float znamky(float znamka1, float znamka2, float znamka3, float znamka4, float znamka5) {
		float priemer = (znamka1 + znamka2 + znamka3 + znamka4 + znamka5) / 5;
		if(priemer < 1.5)
			return 1;
		else if(priemer >= 1.5 && priemer < 2.5)
			return 2;
		else if(priemer >= 2.5 && priemer < 3.5) 
			return 3;
		else if(priemer >= 3.5 && priemer < 4.5)
			return 4;
		else 
			return 5;
	}
	
	
	
}
