package sk.tuke.gamestudio.game.tictactoe;

import sk.tuke.gamestudio.game.tictactoe.consoleui.ConsoleUI;
import sk.tuke.gamestudio.game.tictactoe.core.Field;

public class TicTacToe {
    public static void main(String username) {
        Field field = new Field(9, 9);
        ConsoleUI ui = new ConsoleUI(field, username);
        ui.play();
    }
}
