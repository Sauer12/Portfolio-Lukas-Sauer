package sk.tuke.gamestudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
//import sk.tuke.gamestudio.PlaygroundJPA;
import sk.tuke.gamestudio.service.*;
import sk.tuke.gamestudio.service.*;

@SpringBootApplication
@EntityScan(basePackages = "sk.tuke.gamestudio.entity")
public class GameStudioServer {

    public static void main(String[] args) {
        SpringApplication.run(GameStudioServer.class);
    }

    @Bean
    public ScoreService scoreService() {
        return new ScoreServiceJPA();
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceJPA();
    }

    @Bean
    public RatingService ratingService(){
        return new RatingServiceJPA();
    }

    @Bean
    public CountryService countryService(){
        return new CountryServiceJPA();
    }

    @Bean
    public OccupationService occupationService(){
        return new OccupationServiceJPA();
    }

    @Bean
    public PlayerService playerService(){
        return new PlayerServiceJPA();
    }
}

