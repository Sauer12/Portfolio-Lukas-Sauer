package sk.tuke.gamestudio.game.fifteenpuzzle.consoleui;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.Field;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.FieldState;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.GameStone;

import java.util.Scanner;

public class ConsoleUI {
    private Field field;

    private Scanner scanner = new Scanner(System.in);

    public ConsoleUI(Field field){
        this.field = field;
    }

    public boolean play(){
        long startTime = System.nanoTime();

        do{
            printField();
            enterInput();
            if(field.winControl()) {
                field.setState(FieldState.SOLVED);
            }
        } while(field.getState() == FieldState.PLAYING);

        long endTime = System.nanoTime();
        field.computeScore();

        if(field.getState() == FieldState.SOLVED){
            printField();
            printGameTime();
            System.out.println("YOU WIN!");
            return true;
        }
        else {
            printGameTime();
            System.out.println("You exit game!");
            return false;
        }
    }

    private void printField(){
        System.out.println();
        for(int column = 0; column < field.getColumnCount(); column++){
            for(int row = 0; row < field.getRowCount(); row++){
                if(field.getTile(column, row) instanceof GameStone){
                    if(((GameStone) field.getTile(column, row)).getNumber() > 9){
                        System.out.print(field.getTile(column, row) + "  ");
                    }
                    else{
                        System.out.print(field.getTile(column, row) + "   ");
                    }
                }
                else
                    System.out.print(field.getTile(column, row) + "   ");
            }
            System.out.println();
        }
        System.out.println("\nNumber of moves: " + field.getNumberOfMoves());
        System.out.println();
    }

    private void enterInput() {
        System.out.print("Enter input: ");
        String input = scanner.nextLine();
        if(input != "") {
            int codeOfKey = (int) input.toUpperCase().charAt(0);
            field.swapTiles(codeOfKey);
            if (codeOfKey == 88)
                field.setState(FieldState.UNSOLVED);
        }
    }

    private void printGameTime(){
        if(field.getTotalTimeSeconds() > 59){
            System.out.println("TIME: " + field.getTotalTimeMinutes() + "min " + field.getTotalTimeSeconds() + "sec");
        }
        else
            System.out.println("TIME: " + field.getTotalTimeSeconds() + "sec");
    }
}
