//package sk.tuke.gamestudio.consoleui;
//
//import org.springframework.stereotype.Service;
//import sk.tuke.gamestudio.game.fifteeenpuzzle.FifteenPuzzle;
//import sk.tuke.gamestudio.game.mines.MainMines;
//import sk.tuke.gamestudio.game.mines.core.*;
//import sk.tuke.gamestudio.game.tiles.MainTiles;
//import java.util.Scanner;
//
//public class GameStudioUI {
//
//    public Scanner scanner;
//
//    public GameStudioUI(){
//        scanner = new Scanner(System.in);
//    }
//
//    public void run(String username){
//        printMainMenu(username);
//    }
//
//    private void printMainMenu(String username){
//        String option = "";
//        while(option != "X") {
//            System.out.println();
//            System.out.println("WELCOME " + username);
//            System.out.println("GAMESTUDIO - MENU");
//            System.out.println("━━━━━━━━━━━━━━━━━");
//            System.out.println("1. minesweeper");
//            System.out.println("2. fifteenpuzzle");
//            System.out.println("3. lightsout");
//            System.out.println("X - End program");
//            System.out.print("Enter input: ");
//            option = scanner.nextLine().toUpperCase().trim();
//            switch (option) {
//                case "1":
//                    MainMines.main(username);
//                    break;
//                case "2":
//                    Main.fifteenPuzzle();
//                    break;
//                case "3":
//                    MainTiles.main();
//                    break;
//                case "X":
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid input!");
//            }
//        }
//        System.out.println("You ended program!");
//    }
//}
