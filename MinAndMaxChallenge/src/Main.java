import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double min = 0;
        double max = 0;
        boolean isChar = false;
        double number = 0;
        int counter = 0;

        do{
            try{
                System.out.print("Enter a number: ");
                number = enterNumber(scanner.nextLine());
                if(number > max)
                    max = number;
                if(number < min)
                    min = number;
                counter++;
            }catch (Exception e){
                isChar = true;
            }

        }while(!isChar);

        if(counter > 0) {
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        }
    }

    public static double enterNumber(String number){
        double num = Double.parseDouble(number);
        return num;
    }
}
