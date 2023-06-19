package sk.lukassauer;

import java.util.Scanner;

public class UIMenu {
    private Scanner scanner;
    private Logics logics;

    public UIMenu(Scanner scanner, Logics logics) {
        this.scanner = scanner;
        this.logics = logics;
    }

    public void runApp(){
//        loading lists
        logics.importSettings();
        logics.importAllHistory();
        mainMenu();
//        System.out.println(logics.getItemList().getRepeating() + " " + logics.getItemList().getMode() + " " + logics.getItemList().getHintStart());
//        mainMenu();
    }

    private void mainMenu(){
        String option = "";

        do {
            System.out.println("\nWord Memorizer v0.1");
            System.out.println("1 - Ucit sa");
            System.out.println("2 - Zoznamy");
            System.out.println("3 - Historia ucenia sa");
            System.out.println("4 - Nastavenia");
            System.out.println("X - Koniec");
            System.out.print("Zvolte moznost: ");
            option = scanner.nextLine().toUpperCase();
            switch (option){
                case "1" -> learnMenu();
                case "2" -> listsMenu();
                case "3" -> learningHistory();
                case "4" -> settingsMenu();
                case "X" -> System.out.println("Ukoncil si program!");
                default -> System.out.println("Nespravna moznost, prosim zadaj spravnu moznost!\n\n");
            }
        }while (!option.equals("X"));
    }

    private void learnMenu(){
        System.out.println("\nWord Memorizer v0.1 - Ucenie sa");
//        logics.clearItemList();
        logics.showItemLists(scanner, true);
        logics.learn(scanner);
        logics.importAllHistory();
        logics.clearItemList();
        logics.importSettings();
    }

    private void listsMenu(){
        String option = "";
        do {
            System.out.println("\nWord Memorizer v0.1 - Zoznamy slovicok");
            System.out.println("1 - Vytvorit novy zoznam");
            System.out.println("2 - Zobrazit existujuce zoznamy");
            System.out.println("X - Vratit sa do hlavneho menu");
            System.out.print("Zadaj moznost: ");
            option = scanner.nextLine().toUpperCase();
            switch (option){
                case "1" -> createListUI();
                case "2" -> showListUI();
                case "X" -> System.out.println();
                default -> System.out.println("Nespravna moznost, prosim zadaj spravnu moznost!\n\n");
            }
        }while (!option.equals("X"));

    }

    private void settingsMenu(){
        String option = "";
        screenCleaner();
        do {
            System.out.println("\nWord Memorizer v0.1 - Nastavenia");
            System.out.println("1 - Pocet opakovani slovicka (nastavene: " + logics.getItemList().getRepeating() + ")");
            System.out.println("2 - Mod ucenia sa (nastavene: " + logics.getItemList().getMode() + ")");
            System.out.println("3 - Nastavenie napovedy (nastavene: " + logics.getItemList().getHintStart() + ")");
            System.out.println("X - Vratit sa do hlavneho menu");
            System.out.print("Zadaj moznost: ");
            option = scanner.nextLine();
            switch (option){
                case "1" -> logics.repeatSettings(scanner);
                case "2" -> logics.modeSettings(scanner);
                case "3" -> logics.hintSettings(scanner);
                case "X" -> System.out.println();
                default -> System.out.println("Zadal si nespravnu moznost!");
            }
            logics.importSettings();
        } while(!option.equals("X"));


    }

    private void createListUI(){
        String option = "";
        String name = "";
        int numberOfWords = 0;
        boolean isValid = true;

        screenCleaner();
        do {
            System.out.println("Zoznam musi mat meno dlhe minimalne 3 znaky a nemoze byt dlhise ako 30 znakov!");
            System.out.print("Zadaj meno zoznamu: ");
            name = scanner.nextLine();
            if(name.equals("X")){
                return;
            }
            else if (name.length() > 30 || name.length() < 3) {
                System.out.println("Zadal si nevalidne alebo umeno zoznamu, prosim zadaj ine meno zoznamu");
                isValid = false;
            } else if(logics.checkFile(name)){
                System.out.println("List s danym nazvom uz existuje, zadaj iny nazov!");
                isValid = false;
            }else{
                isValid = true;
            }
        } while(!isValid);

        screenCleaner();
        do {
            isValid = true;
            System.out.println("Zoznam moze obsahovat minimalne 3 slova a maximalne 50 slov!");
            System.out.print("Kolko slov ma obsahovat tvoj zoznam?: ");
            try {
                numberOfWords = Integer.parseInt(scanner.nextLine());
                if(numberOfWords == 0){
                    return;
                }
                else if(numberOfWords > 50 || numberOfWords < 3){
                    System.out.println("Prosim zadaj validne cislo!");
                    isValid = false;
                }
            } catch (Exception e){
                System.out.println("Zadal si nespravnu moznost, prosim zadaj iba cislo!");
                isValid = false;
            }
        }while (!isValid);

        logics.createItemList(name, numberOfWords, scanner);
        logics.importSettings();
    }

    private void showListUI(){
        screenCleaner();
        System.out.println("Tvoje vytvorene listy:");
        logics.showItemLists(scanner, false);
    }

    private void learningHistory(){
        screenCleaner();
        System.out.println("Word Memorizer v0.1 - Historia ucenia");
        logics.printHistory();
        System.out.print("\nKlikni lubovolnu klavesu pre navrat do menu: ");
        scanner.nextLine();
    }

    private void screenCleaner(){
        System.out.println("\n".repeat(100));
    }
}
