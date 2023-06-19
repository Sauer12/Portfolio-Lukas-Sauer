import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        boolean exit = false;
        String option = "";

        while(!exit){
            System.out.println("0 - shutdown");
            System.out.println("1 - add item(s) to list");
            System.out.println("2 - remove any item(s)");
            System.out.print("Enter a number for which action you want to do: ");
            option = scanner.nextLine();
            switch (option){
                case "0" -> exit = true;
                case "1" -> addItemsToList(arrayList, scanner);
                case "2" -> removeItemsFromList(arrayList, scanner);
                default -> System.out.println("Invalid input!");
            }
        }
    }

    public static void addItemsToList(ArrayList<String> arrayList, Scanner scanner){
        String input;
        System.out.println("ADD");
        System.out.print("Enter value(s) with comma delimited: ");
        input = scanner.nextLine();
        String[] values = input.split(";");
        for(int i = 0; i < values.length; i++){
            if(!arrayList.contains(values[i])) {
                arrayList.add(values[i]);
            }
        }

        arrayList.sort(Comparator.naturalOrder());
        System.out.println(arrayList);
    }


    public static void removeItemsFromList(ArrayList<String> arrayList, Scanner scanner){
        String input;
        System.out.println("DELETE");
        System.out.println("Enter value(s) with comma delimited:");
        input = scanner.nextLine();
        String[] values = input.split(";");
        for(int i = 0; i < values.length; i++){
            if(arrayList.contains(values[i])){
                arrayList.remove(values[i]);
            }
        }

        System.out.println(arrayList);
    }
}
