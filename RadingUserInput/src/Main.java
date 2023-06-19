import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int number = 0;
        for(int i = 0; i < 5; i++) {
            try {
                System.out.print("Enter number #" + (i + 1) + ": ");
                number = Integer.parseInt(scanner.nextLine());
                sum += number;
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
        }

        System.out.println(sum);
    }
}
