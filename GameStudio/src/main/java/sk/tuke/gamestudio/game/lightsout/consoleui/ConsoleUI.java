package sk.tuke.gamestudio.game.lightsout.consoleui;

import sk.tuke.gamestudio.game.lightsout.core.Field;
import sk.tuke.gamestudio.game.lightsout.core.LightState;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI {
    private Field field;

    private Scanner scanner = new Scanner(System.in);
    public ConsoleUI(Field field){
        this.field = field;
    }

    public boolean play(){
        long startTime = System.nanoTime();
        boolean end = true;

        do {
            printField();
            end = processInput();
        }while(!field.winControl() && end);

        long endTime = System.nanoTime();
        field.computeScore();

        if(!end) {
            printGameTime();
            return false;
        }

        printField();
        printGameTime();
        System.out.println(field.getState());
        return true;
    }

    private void printField(){
        printHeader();
        for(int row = 0; row < field.getRowCount(); row++){
            System.out.print((char)('A' + row) + " " + "┃ ");
            for(int column = 0; column < field.getColumnCount(); column++){
                if(field.getTile(row, column).getState() == LightState.LIGHTOFF)
                    System.out.print("- ");
                else
                    System.out.print("O ");
            }
            System.out.print("┃");
            System.out.println();
        }
        printFooter();
        System.out.println("\nNumber of moves: " + field.getNumberOfMoves());
        System.out.println();
    }

    private void printHeader(){
        System.out.println();
        System.out.print("    ");
        for(int row = 0; row < field.getRowCount(); row++){
            System.out.print((row + 1) + " ");
        }
        System.out.println();
        System.out.print("  ┏");
        for(int row = 0; row < field.getRowCount(); row++){
            System.out.print("━━");
        }
        System.out.print("━┓");
        System.out.println();
    }

    private void printFooter(){
        System.out.print("  ┗");
        for(int row = 0; row < field.getRowCount(); row++){
            System.out.print("━━");
        }
        System.out.print("━┛");
    }

    private boolean processInput(){
        System.out.print("Enter input: ");
        String line = scanner.nextLine().toUpperCase().trim();
        if("X".equals(line))
            return false;
        Pattern pattern = Pattern.compile("([A-E])([1-5])");
        Matcher matcher = pattern.matcher(line);
        if(matcher.matches()){
            int row = matcher.group(1).charAt(0) - 'A';
            int column = Integer.parseInt(matcher.group(2)) - 1;
//            System.out.println(row + " " + column);
            field.changeTiles(row, column);
            field.setNumberOfMoves(field.getNumberOfMoves() + 1);
        }
        else
            System.err.println("Invalid input!");

        return true;
    }

    private void printGameTime(){
        if(field.getTotalTimeSeconds() > 59){
            System.out.println("TIME: " + field.getTotalTimeMinutes() + "min " + field.getTotalTimeSeconds() + "sec");
        }
        else
            System.out.println("TIME: " + field.getTotalTimeSeconds() + "sec");
    }
}
