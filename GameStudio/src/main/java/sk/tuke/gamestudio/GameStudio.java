package sk.tuke.gamestudio;

import org.springframework.beans.factory.annotation.Autowired;
import sk.tuke.gamestudio.entity.*;
//import sk.tuke.gamestudio.exceptions.*;
import sk.tuke.gamestudio.game.minesweeper.consoleui.ConsoleUI;
import sk.tuke.gamestudio.game.minesweeper.core.*;
import sk.tuke.gamestudio.service.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameStudio {
    private String username;
    private Scanner scanner = new Scanner(System.in);
    private Score score;
    private Comment comment;
    private Rating rating;
    private Country country;
    private Occupation occupation;
    private Player player;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private OccupationService occupationService;
    @Autowired
    private PlayerService playerService;
    @PersistenceContext
    private EntityManager entityManager;
    public void run() {
        score = new Score();
        comment = new Comment();
        rating = new Rating();
        player = new Player();
        occupation = new Occupation();
        country = new Country();
        printLoginSystem();
        printMainMenu();
    }

    private void printLoginSystem() {
        System.out.println("WELCOME - ENTER YOUR USERNAME");
        username = scanner.nextLine().trim();
        if (playerService.getPlayerByUserName(username) == null) {
            System.out.println("Username is not in database, you have to register!");
            int countryIndex = printCountryList();
            boolean correctInput = false;
            while(!correctInput){
                if (countryIndex == countryService.getCountries().size()) {
                    System.out.print("Enter your country: ");
                    String country = scanner.nextLine();
                    countryService.addCountry(new Country(country));
                    player.setCountry(countryService.getCountries().get(countryIndex));
                    correctInput = true;
                }
                else if(countryIndex >= 0 && countryIndex < countryService.getCountries().size()){
                    player.setCountry(countryService.getCountries().get(countryIndex));
                    correctInput = true;
                }
            }


            int occupationIndex = printOccupationList();
            player.setOccupation(occupationService.getOccupations().get(occupationIndex));
            player.setUserName(username);
            player.setLevel(1);

            System.out.println("Do you want add some info about you?(Max 500 characters)[YES/NO]");
            String aboutMe;
            if(scanner.nextLine().toUpperCase().equals("YES")){
                boolean maximumLength = false;
                while(!maximumLength) {
                    System.out.println("Write something about yourself");
                    aboutMe = scanner.nextLine();
                    if (aboutMe.length() <= 500) {
                        player.setAboutMe(aboutMe);
                        maximumLength = true;
                    }
                }
            }
            else
                player.setAboutMe("");

            playerService.addPlayer(player);
        }
    }

    private void printMainMenu() {
        String option = "";
        while (!(option.equals("X"))){
            System.out.println();
            System.out.println("WELCOME " + username);
            System.out.println("GAMESTUDIO - MENU");
            System.out.println("━━━━━━━━━━━━━━━━━");
            System.out.println("1. minesweeper");
            System.out.println("2. fifteenpuzzle");
            System.out.println("3. lightsout");
            System.out.println("4. tictactoe");
            System.out.println("X - End program");
            System.out.print("Enter input: ");
            option = scanner.nextLine().toUpperCase().trim();
            switch(option) {
                case "1":
                    minesweeperPlay();
                    break;
                case "2":
                    puzzlePlay();
                    break;
                case "3":
                    lightsoutPlay();
                    break;
                case "4":
                    tictactoePlay();
                    break;
                case "X":
                    System.out.println("You ended program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    public void minesweeperPlay() {
        String game = "Mines";
        var field = new Field(9, 9, 1);
        var ui = new ConsoleUI(field, username);
        ui.play();
        score.setGame(game);
        score.setUsername(username);
        score.setPlayedAt(new Date());
        score.setPoints(field.computeScore());
        comment.setGame(game);
        rating.setGame(game);
        if (field.getState() == FieldState.SOLVED) {
            scoreService.addScore(score);
        }
        System.out.println(score);

//        Vypise top 5 hracov
        printTopPlayers(game);
////        Vypise komenty
        printComments(game);
//        Vypise priemerny rating hry
        avgRating();

//        Prida moznost pridat komentar a rating, ak je hra vyhrata
        if (field.getState() == FieldState.SOLVED) {
            setComment(game);
            System.out.println();
            setRating(game);
        }
    }

    public void puzzlePlay(){
        String game = "Fifteen Puzzle";
        var field = new sk.tuke.gamestudio.game.fifteenpuzzle.core.Field(4, 4);
        var ui = new sk.tuke.gamestudio.game.fifteenpuzzle.consoleui.ConsoleUI(field);
        ui.play();
        score.setGame(game);
        score.setUsername(username);
        score.setPlayedAt(new Date());
        score.setPoints(field.computeScore());
        comment.setGame(game);
        rating.setGame(game);
        if (field.getState() == sk.tuke.gamestudio.game.fifteenpuzzle.core.FieldState.SOLVED) {
            scoreService.addScore(score);
        }
        System.out.println(score);

//        Vypise top 5 hracov
        printTopPlayers(game);
////        Vypise komenty
        printComments(game);
//        Vypise priemerny rating hry
        avgRating();

//        Prida moznost pridat komentar a rating, ak je hra vyhrata
        if (field.getState() == sk.tuke.gamestudio.game.fifteenpuzzle.core.FieldState.SOLVED) {
            setComment(game);
            System.out.println();
            setRating(game);
        }
    }

    //DOKONCIT!
    public void lightsoutPlay(){
        String game = "Lights out";
        var field = new sk.tuke.gamestudio.game.lightsout.core.Field(5, 5);
        var ui = new sk.tuke.gamestudio.game.lightsout.consoleui.ConsoleUI(field);
        ui.play();
        score.setGame(game);
        score.setUsername(username);
        score.setPlayedAt(new Date());
        score.setPoints(field.computeScore());
        comment.setGame(game);
        rating.setGame(game);
        if (field.getState() == sk.tuke.gamestudio.game.lightsout.core.FieldState.SOLVED) {
            scoreService.addScore(score);
        }
        System.out.println(score);

//        Vypise top 5 hracov
        printTopPlayers(game);
////        Vypise komenty
        printComments(game);
//        Vypise priemerny rating hry
        avgRating();

//        Prida moznost pridat komentar a rating, ak je hra vyhrata
        if (field.getState() == sk.tuke.gamestudio.game.lightsout.core.FieldState.SOLVED) {
            setComment(game);
            System.out.println();
            setRating(game);
        }
    }

    public void tictactoePlay(){
        String game = "TicTacToe";
        var field = new sk.tuke.gamestudio.game.tictactoe.core.Field(9, 9);
        var ui = new sk.tuke.gamestudio.game.tictactoe.consoleui.ConsoleUI(field, username);
        ui.play();
        score.setGame(game);
        score.setUsername(username);
        score.setPlayedAt(new Date());
        score.setPoints(field.computeScore());
        comment.setGame(game);
        rating.setGame(game);
        if (field.getState() == sk.tuke.gamestudio.game.tictactoe.core.FieldState.OWIN ||
                field.getState() == sk.tuke.gamestudio.game.tictactoe.core.FieldState.XWIN) {
            scoreService.addScore(score);
        }
        System.out.println(score);

//        Vypise top 5 hracov
        printTopPlayers(game);
////        Vypise komenty
        printComments(game);
//        Vypise priemerny rating hry
        avgRating();

//        Prida moznost pridat komentar a rating, ak je hra vyhrata
        if (field.getState() == sk.tuke.gamestudio.game.tictactoe.core.FieldState.OWIN ||
                field.getState() == sk.tuke.gamestudio.game.tictactoe.core.FieldState.XWIN) {
            setComment(game);
            System.out.println();
            setRating(game);
        }
    }


    private int printCountryList() {
        System.out.println("COUNTRY LIST");
        List<Country> countries = countryService.getCountries();
        for(int i = 1; i <= countries.size(); i++) {
            System.out.println(i + ". - " + countries.get(i - 1));
        }
        System.out.println((countries.size() + 1) + ". - enter new country");
        Pattern pattern = null;
        Matcher matcher = null;
        while(true){
            String option;
            System.out.print("Enter input: ");
            option = scanner.nextLine().toUpperCase().trim();
            pattern = pattern.compile("([1-9][0-9]{0,2})");
            matcher = pattern.matcher(option);
            if(matcher.matches()){
                int indexOfCountry = Integer.parseInt(option) - 1;
                if(indexOfCountry >= 0 && indexOfCountry <= countryService.getCountries().size()){
                    return indexOfCountry;
                }
                else {
                    System.out.println("Invalid input!");
                }
            }
            else
                System.out.println("Invalid input!");
        }
    }

    private int printOccupationList() {
        System.out.println("OCCUPATION LIST");
        List<Occupation> occupations = occupationService.getOccupations();
        for(int i = 1; i <= occupations.size(); i++){
            System.out.println(i + ". - " + occupations.get(i - 1));
        }
        System.out.print("Choose your option: ");
        String option = scanner.nextLine();
        return Integer.parseInt(option) - 1;
    }


    private void printTopPlayers(String game){
        System.out.println("\nTOP 5 PLAYERS");
        List<Score> scores = scoreService.getBestScores(game);
        for (var score : scores) {
            System.out.println(score);
        }
    }
    private void printComments(String game){
        System.out.println("\nCOMMENTS");
        List<Comment> comments = commentService.getComments(game);
        for (var comment : comments) {
            System.out.println(comment);
        }
    }
    private void avgRating(){
        System.out.println("\nRATING");
        System.out.print("Average rating: ");
        System.out.println(ratingService.getAverageRating(rating.getGame()));
    }
    private void setRating(String game){
        System.out.print("Do you want leave a rating?[yes/no]: ");
        String option = scanner.nextLine().toUpperCase().trim();
        if (option.equals("YES")) {
            System.out.println("Please leave a rating: [1-5]");
            int ratingValue = Integer.parseInt(scanner.nextLine());
            System.out.println(ratingValue);
            if (ratingValue > 0 && ratingValue < 6) {
                rating.setGame(game);
                rating.setUsername(username);
                rating.setRating(ratingValue);
                rating.setRated_at(new Date());
                ratingService.setRating(rating);
            }
        }
    }
    private void setComment(String game){
        System.out.print("Do you want leave a comment?[yes/no]: ");
        String option = scanner.nextLine().toUpperCase().trim();
        if (option.equals("YES")) {
            System.out.print("Please leave a comment: ");
            String text = scanner.nextLine();
            comment.setGame(game);
            comment.setComment(text);
            comment.setUsername(username);
            comment.setCommented_at(new Date());
            commentService.addComment(comment);
        }
    }
}
