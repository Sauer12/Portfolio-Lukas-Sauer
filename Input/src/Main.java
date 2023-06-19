
import java.util.Scanner;

/**
 * 
 * @author Luxy
 *
 */
public class Main {

	public static void main(String[] args) {
		input();
	}
	
	private static void input() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter something: ");
			String input = scanner.nextLine();
			
			if("e".equals(input)) {
				System.out.println("Exit");
				break;
			}
			
			System.out.println("Input : " + input);
			System.out.println("-------------\n");
		}
		
		scanner.close();		
	}

}
