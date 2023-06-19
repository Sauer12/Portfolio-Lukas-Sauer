package sk.tuke.gamestudio.game.fifteenpuzzle;


import sk.tuke.gamestudio.game.fifteenpuzzle.consoleui.ConsoleUI;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.Field;

public class FifteenPuzzle {

    public void puzzlePlay() {
        Field field = new Field(4, 4);
//        ConsoleGUI consoleGUI = new ConsoleGUI(field);
//        consoleGUI.setVisible(true);
//        consoleGUI.play();
        ConsoleUI consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }
}
