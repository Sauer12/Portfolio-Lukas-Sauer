package sk.tuke.gamestudio;

import sk.tuke.gamestudio.GameStudio;

public class Main {
    public static void main(String[] arg) {
//        String username = System.getProperty("user.name");
        GameStudio gameStudio = new GameStudio();
        gameStudio.run();
    }
}
