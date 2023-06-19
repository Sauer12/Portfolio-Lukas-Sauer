package sk.tuke.gamestudio.game.tictactoe.consoleui;

import sk.tuke.gamestudio.game.tictactoe.core.Field;
import sk.tuke.gamestudio.game.tictactoe.core.FieldState;
import sk.tuke.gamestudio.game.tictactoe.core.Stone;
import sk.tuke.gamestudio.game.tictactoe.core.StoneState;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUI {
    private Field field;
    private Scanner scanner = new Scanner(System.in);
    private String username;

    private boolean xStone = true;

    public ConsoleUI(Field field, String username){
        this.field = field;
        this.username = username;
    }

    public boolean play() {
        boolean end = false;
        do {
            System.out.println("Do u want play with X or O?");
            System.out.println("1. - X");
            System.out.println("2. - O");
            System.out.print("Option: ");
            String option = scanner.nextLine().toUpperCase();
            if (option.equals("1") || option.equals("2")) {
                if(option.equals("2"))
                    xStone = false;
                end = true;
            } else {
                System.err.println("Invalid option!\n");
            }
        }while(!end);

        end = false;

        do{
            printField();
            end = processInput();
        } while (field.getState() == FieldState.PLAYING && !end);

        if(end)
            return false;

        printField();
        System.out.println(field.getState());

        return true;
    }

    private boolean processInput() {
        System.out.print("Enter input: ");;
        String input = scanner.nextLine().toUpperCase().trim();
        if("X".equals(input))
            return true;
        var pattern = Pattern.compile("([A-I])([1-9])");
        var matcher = pattern.matcher(input);
        if(matcher.matches()){
            var row = matcher.group(1).charAt(0) - 'A';
            var column = Integer.parseInt(matcher.group(2)) - 1;
            if(field.getStone(row, column).getStoneState() == StoneState.EMPTY) {
                field.setStone(row, column, xStone);
                printField();
                if(field.getState() == FieldState.OWIN || field.getState() == FieldState.XWIN)
                    return false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                field.computerSetStone(!xStone);
            }
            else
                System.out.println("You can set stone only on the empty position!");
        }else{
            System.out.println("Invalid input!");
        }
        return false;
    }

    private void printField(){
        printFieldHeader();
        printFieldBody();
    }

    private void printFieldHeader(){
        for(int column = 0; column < field.getRowCount(); column++){
            System.out.print("  ");
            System.out.print(column + 1);
        }
        System.out.println();
    }

    private void printFieldBody(){
        for(int row = 0; row < field.getRowCount(); row++){
            System.out.print((char) ('A' + row));
            for(int column = 0; column < field.getColumnCount(); column++){
                Stone stone = field.getStone(row, column);
                if(stone.getStoneState() == StoneState.EMPTY)
                    System.out.print(" - ");
                else if(stone.getStoneState() == StoneState.X)
                    System.out.print(" X ");
                else
                    System.out.print(" O ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
