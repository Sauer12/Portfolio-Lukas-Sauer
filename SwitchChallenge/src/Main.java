// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[] characters = {'B', 'A', 'D', 'E', 'C'};
        char character = 'A';

        for(int i = 0; i < 5; i++){
            switcher(characters[i]);
        }

        System.out.println();

        for(int i = 0; i < 8; i++){
            printDayOfWeek(i);
        }
    }

    public static void switcher(char ch){
        switch (ch){
            case 'A':
                System.out.println("Able");
                break;
            case 'B':
                System.out.println("Baker");
                break;
            case 'C':
                System.out.println("Charlie");
                break;
            case 'D':
                System.out.println("Dog");
                break;
            case 'E':
                System.out.println("Easy");
                break;
            default:
                System.out.println("Wrong!");
        }
    }

    public static void printDayOfWeek(int day){

        String dayOfWeek = switch (day){
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid day";
        };

        System.out.println(day + " : " + dayOfWeek);
    }
}
