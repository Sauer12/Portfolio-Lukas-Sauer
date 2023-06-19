package sk.tuke.gamestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.exceptions.*;
import sk.tuke.gamestudio.service.*;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "sk.tuke.gamestudio.server.*"))
public class SpringClient {

    public static void main(String[] args) {

//        SpringApplication.run(SpringClient.class);

//        nespusti server!
        new SpringApplicationBuilder(SpringClient.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public CommandLineRunner runnerGameStudio(GameStudio gameStudio){
        return args -> {
            gameStudio.run();
        };
    }

    @Bean
    public GameStudio gameStudio(){
        return new GameStudio();
    }

//    @Bean
//    public CommandLineRunner runnerPlaygroundJPA(PlaygroundJPA console) {
//        return args -> {
//            console.play();
//        };
//    }

//    @Bean
//    public CommandLineRunner runnerMines(ConsoleUI console) {
//        return args -> {
//            console.play();
//        };
//    }

//    @Bean
//    public PlaygroundJPA consolePlaygroundJPA(){
//        return new PlaygroundJPA();
//    }



    //@Bean
//    public CommandLineRunner runnerTiles(sk.tuke.gamestudio.game.tiles.consoleui.ConsoleUI console) {
//        return args -> {
//            console.play();
//        };
//    }


//    @Bean
//    public ConsoleUI consoleMines(Field field) {
//        return new ConsoleUI(field, "Lukas");
//    }

//    @Bean
//    public sk.tuke.gamestudio.game.tiles.consoleui.ConsoleUI consoleTiles(sk.tuke.gamestudio.game.tiles.core.Field field) {
//        return new sk.tuke.gamestudio.game.tiles.consoleui.ConsoleUI(field);
//    }

//    @Bean
//    public Field fieldMines() {
//        return new Field(9, 9, 1);
//    }

//    @Bean
//    public sk.tuke.gamestudio.game.tiles.core.Field fieldTiles() {
//        return new sk.tuke.gamestudio.game.tiles.core.Field(10, 10);
//    }

    @Bean
    public ScoreService scoreService() {
        return new ScoreServiceREST();
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceREST();
    }

    @Bean
    public RatingService ratingService(){
        return new RatingServiceREST();
    }

    @Bean
    public CountryService countryService(){
        return new CountryServiceREST();
    }

    @Bean
    public OccupationService occupationService(){
        return new OccupationServiceREST();
    }

    @Bean
    public PlayerService playerService() { return new PlayerServiceREST();}

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

