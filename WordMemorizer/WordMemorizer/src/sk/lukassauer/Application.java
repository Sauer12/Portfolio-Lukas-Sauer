package sk.lukassauer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        UIMenu uiMenu = new UIMenu(new Scanner(System.in), new Logics());
        uiMenu.runApp();
    }
}
