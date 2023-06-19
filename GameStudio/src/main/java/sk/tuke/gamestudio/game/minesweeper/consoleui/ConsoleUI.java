package sk.tuke.gamestudio.game.minesweeper.consoleui;

import org.springframework.beans.factory.annotation.Autowired;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.game.minesweeper.core.FieldState;
import sk.tuke.gamestudio.game.minesweeper.core.Clue;
import sk.tuke.gamestudio.game.minesweeper.core.Field;
import sk.tuke.gamestudio.game.minesweeper.core.Tile;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.RatingService;
import sk.tuke.gamestudio.service.ScoreService;


import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUI {
    private Field field;
    private Scanner scanner = new Scanner(System.in);

    private String username;
    private Score score;
    private Comment comment;
    private Rating rating;
    @Autowired
    public ScoreService scoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;

    public ConsoleUI(Field field, String username) {
        this.field = field;
        this.username = username;
    }

    public boolean play() {
        boolean end = true;

        do {
            printField();
            end = processInput();
        } while (field.getState() == FieldState.PLAYING && end);


        if(!end)
            return false;

        printField();
        System.out.println(field.getState());


//        if(field.getState() == FieldState.SOLVED) {
//            scoreService.addScore(score);
//        }

//        Vypise top 5 hracov
//        System.out.println("\nTOP 5 PLAYERS");
//        List<Score> scores = scoreService.getBestScores("Mines");
//        for(var score : scores){
//            System.out.println(score);
//        }
////        Vypise komenty
//        System.out.println("\nCOMMENTS");
//        List<Comment> comments = commentService.getComments("Mines");
//        for(var comment : comments){
//            System.out.println(comment);
//        }
////        Vypise priemerny rating hry
//        System.out.println("\nRATING");
//        System.out.print("Average rating: ");
//        System.out.println(ratingService.getAverageRating(rating.getGame()));
//
////        Prida moznost pridat komentar a rating, ak je hra vyhrata
//        if(field.getState() == FieldState.SOLVED) {
//            System.out.print("Do you want leave a comment?[yes/no]: ");
//            String option = scanner.nextLine().toUpperCase().trim();
//            if (option.equals("YES")) {
//                System.out.print("Please leave a comment: ");
//                String text = scanner.nextLine();
//                comment.setGame("Mines");
//                comment.setComment(text);
//                comment.setUsername(username);
//                comment.setCommented_at(new Date());
//                commentService.addComment(comment);
//            }
//            System.out.print("Do you want leave a rating?[yes/no]: ");
//            option = scanner.nextLine().toUpperCase().trim();
//            if (option.equals("YES")) {
//                System.out.println("Please leave a rating: [1-5]");
//                int ratingValue = scanner.nextInt();
//                System.out.println(ratingValue);
//                if (ratingValue > 0 && ratingValue < 6) {
//                    rating.setGame("Mines");
//                    rating.setUsername(username);
//                    rating.setRating(ratingValue);
//                    rating.setRated_at(new Date());
//                    ratingService.setRating(rating);
//                }
//            }
//        }

        return true;
    }

    private boolean processInput() {
        System.out.print("Enter input: ");
        var line = scanner.nextLine().toUpperCase().trim();
        if ("X".equals(line))
            return false;
        var pattern = Pattern.compile("([OM])([A-I])([1-9])");
        var matcher = pattern.matcher(line);
        if (matcher.matches()) {
            var row = matcher.group(2).charAt(0) - 'A';
            var column = Integer.parseInt(matcher.group(3)) - 1;
            if("O".equals(matcher.group(1)))
                field.openTile(row, column);
            else
                field.markTile(row, column);
            field.setNumberOfMoves(field.getNumberOfMoves() + 1);
        } else {
            System.err.println("Invalid input!");
        }
        return true;
    }

    private void printField() {
        printFieldHeader();
        printFieldBody();
    }

    private void printFieldBody() {
        for (var row = 0; row < field.getRowCount(); row++) {
            System.out.print((char) ('A' + row));
            for (var column = 0; column < field.getColumnCount(); column++) {
                var tile = field.getTile(row, column);
                System.out.print(" ");
                printTile(tile);
            }
            System.out.println();
        }
        System.out.println("\nNumber of moves: " + field.getNumberOfMoves());
        System.out.println();
    }

    private void printFieldHeader() {
        System.out.print(" ");
        for (var column = 0; column < field.getColumnCount(); column++) {
            System.out.print(" ");
            System.out.print(column + 1);
        }
        System.out.println();
    }

    private void printTile(Tile tile) {
        switch (tile.getState()) {
            case CLOSED:
                System.out.print("-");
                break;
            case MARKED:
                System.out.print("M");
                break;
            case OPEN:
                if (tile instanceof Clue)
                    System.out.print(((Clue) tile).getValue());
                else
                    System.out.print("X");
        }
    }

//    private void printGameTime(){
//        if(field.getTotalTimeSeconds() > 59){
//            System.out.println("TIME: " + field.getTotalTimeMinutes() + "min " + field.getTotalTimeSeconds() + "sec");
//        }
//        else
//            System.out.println("TIME: " + field.getTotalTimeSeconds() + "sec");
//    }
}
