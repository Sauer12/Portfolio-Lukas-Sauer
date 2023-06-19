package sk.tuke.gamestudio.game.minesweeper;

import sk.tuke.gamestudio.game.minesweeper.consoleui.ConsoleUI;
import sk.tuke.gamestudio.game.minesweeper.core.Field;

public class Minesweeper {
    public static void main(String username){
        var field = new Field(9, 9, 1);
        var ui = new ConsoleUI(field, username);
        ui.play();
    }
}
