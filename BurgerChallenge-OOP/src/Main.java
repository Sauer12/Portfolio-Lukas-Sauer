import java.util.Scanner;

public class Main {
    static MealOrder mealOrder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choise = "";

        do{
            System.out.println("Welcome to the Bill's restaurant!");
            System.out.println("1 - Order meal/drink");
            System.out.println("2 - Show menu and prices");
            System.out.println("X - Quit!");
            System.out.println("Enter your choise: ");
            choise = scanner.nextLine().toUpperCase();
            switch (choise){
                case "1" -> orderMealDrink(scanner);
                case "2" -> showMenu();
                case "X" -> System.out.println("You quit, program ended!");
                default -> System.out.println("You picked wrong choise, try again!");
            }
        }while(!(choise.equals("X")));
    }

    public static void orderMealDrink(Scanner scanner){
        String choise = "";
        do {
            System.out.println("\n\nSelect your burger:");
            System.out.println("1 - Classic burger");
            System.out.println("2 - Hamburger");
            System.out.println("X - Quit!");
            choise = scanner.nextLine().toUpperCase();
            switch (choise){
                case "1" -> chooseSize(scanner, "Burger");
                case "2" -> chooseSize(scanner, "Hamburger");
                case "X" -> System.out.println("You canceled your order!");
                default -> System.out.println("Wrong choise, try again!");
            }
        }while(!(choise.equals("X")));
    }

    public static void showMenu(){
        System.out.println("Menu:");
    }

    public static void chooseSize(Scanner scanner, String type){
        String choise = "";
        do {
            System.out.println("\n\nSelect your size:");
            System.out.println("1 - Small (1 meat, 2 ingredients)");
            System.out.println("2 - Medium (2 meats, 2 ingredients)");
            System.out.println("3 - Large (3 meats, 3 ingredients)");
            System.out.println("X - Quit!");
            choise = scanner.nextLine().toUpperCase();
            if(choise.equals("1")){
                if(type.equals("Burger"))
                    mealOrder = new MealOrder(new Burger("Classic Burger", "small", 1, 2));
                else if(type.equals("Hamburger"))
                    mealOrder = new MealOrder(new Hamburger("small", 1, 1, 2));
                showPrice();
            }
            else if(choise.equals("2")){
                if(type.equals("Burger"))
                    mealOrder = new MealOrder(new Burger("Classic Burger", "medium", 2, 2));
                else if(type.equals("Hamburger"))
                    mealOrder = new MealOrder(new Hamburger("medium", 2, 2, 4));
                showPrice();
            }
            else if(choise.equals("3")){
                if(type.equals("Burger"))
                    mealOrder = new MealOrder(new Burger("Classic Burger", "large", 3, 3));
                else if(type.equals("Hamburger"))
                    mealOrder = new MealOrder(new Hamburger("large", 3, 3, 5));
                showPrice();
            }
            else if(choise.equals("X")){
                System.out.println("You quit!");
            } else{
                System.out.println("You select wrong option, try again!");
            }
        }while(!(choise.equals("X")));
    }

    public static void showPrice(){
        System.out.println("\n\nSUMMARY:");
        System.out.println(mealOrder);
        System.out.println("\nWait for your order, enjoy your meal!");
    }
}
