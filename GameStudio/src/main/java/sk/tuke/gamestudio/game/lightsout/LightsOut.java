package sk.tuke.gamestudio.game.lightsout;

import sk.tuke.gamestudio.game.lightsout.consoleui.ConsoleUI;
import sk.tuke.gamestudio.game.lightsout.core.*;


public class LightsOut {

    public static void main() {
        Field field = new Field(5, 5);
        ConsoleUI consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }
}
