import java.util.Scanner;

public class GameUI {
    private Scanner scanner;

    public GameUI() {
        scanner = new Scanner(System.in);
    }

    public void menu(){
        boolean quit = false;

        while(!quit) {
            System.out.println("\n\nWelcome in Pexeso game!");
            System.out.println("1 - Play");
            System.out.println("X - Quit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1" -> play();
                case "X" -> quit = true;
                default -> System.out.println("Invalid choice, please try again!");
            }
        }

        System.out.println("You ended program...");
    }

    private void play(){
        PlayingArea playingArea = new PlayingArea(2, 3, "ABC");
        playingArea.createCardsWithTypes();
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int movementCounter = 0;

        while(!playingArea.isFinish()){
            playingArea.displayArea();
            System.out.print("\nEnter position X: ");
            String inputX = scanner.nextLine().toUpperCase();
            if(inputX.equals("X")){
                break;
            }
            System.out.print("Enter position Y: ");
            String inputY = scanner.nextLine().toUpperCase();
            if(inputY.equals("X")){
                break;
            }

            try{
                int x = Integer.parseInt(inputX);
                int y = Integer.parseInt(inputY);
                if((x >= 0 && x < playingArea.getRows()) && (y >= 0 && y < playingArea.getColumns())){
                    playingArea.moveOpen(x, y);
                    if(movementCounter == 0){
                        x1 = x;
                        y1 = y;
                        movementCounter++;
                    }
                    else{
                        x2 = x;
                        y2 = y;
                        movementCounter--;
                        playingArea.displayArea();
                        if(playingArea.checkCardsEqual(x1, y1, x2, y2)){
                            System.out.println("You guessed 1 pair!");
                        }
                        else{
                            playingArea.moveClose(x1, y1);
                            playingArea.moveClose(x2, y2);
                        }
                        Thread.sleep(2000);
                    }
                } else{
                    System.out.println("You entered invalid input!");
                }
            }catch (Exception e){
                System.out.println("You entered invalid input!");
            }

            playingArea.checkGame();
        }
    }
}
