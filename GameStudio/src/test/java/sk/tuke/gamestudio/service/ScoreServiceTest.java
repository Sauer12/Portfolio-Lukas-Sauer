package sk.tuke.gamestudio.service;

import org.junit.Test;
import sk.tuke.gamestudio.entity.Score;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreServiceTest {
    private final ScoreService scoreService = new ScoreServiceFile();

    @Test
    public void testReset(){
        scoreService.addScore(new Score("mines", "Lukas", 100, new Date()));

        boolean atLeastOne = false;
        if(scoreService.getBestScores("mines").size()>0){
            atLeastOne=true;
        }
        assertTrue(atLeastOne);

        assertNotEquals(0, scoreService.getBestScores("mines").size());
        scoreService.reset();
        assertEquals(0, scoreService.getBestScores("mines").size());
    }

    @Test
    public void testAddScore(){
        scoreService.reset();
        var date = new Date();
        final String gameName = "mines";

        scoreService.addScore(new Score(gameName, "Jano", 123, date));

        var scores = scoreService.getBestScores("mines");

        assertEquals(1, scores.size());

        assertEquals(gameName, scores.get(0).getGame());
        assertEquals("Jano", scores.get(0).getUsername());
        assertEquals(123, scores.get(0).getPoints());
        assertEquals(date, scores.get(0).getPlayedAt());
    }

    @Test
    public void testBestScores(){
        scoreService.reset();

        var date = new Date();
        scoreService.addScore(new Score("mines", "Karol", 150, date));
        scoreService.addScore(new Score("mines", "Lukas", 100, date));
        scoreService.addScore(new Score("mines", "Marek", 170, date));
        scoreService.addScore(new Score("mines", "Anna", 55, date));
        scoreService.addScore(new Score("mines", "Simona", 10, date));
        scoreService.addScore(new Score("mines", "Lubica", 85, date));
        scoreService.addScore(new Score("tiles", "Peter", 500, date));
        var scores = scoreService.getBestScores("mines");

        assertEquals(5, scoreService.getBestScores("mines").size());

        assertEquals("mines",scores.get(0).getGame());
        assertEquals("Marek", scores.get(0).getUsername());
        assertEquals(170, scores.get(0).getPoints());
        assertEquals(date, scores.get(0).getPlayedAt());

        assertEquals("mines",scores.get(1).getGame());
        assertEquals("Karol", scores.get(1).getUsername());
        assertEquals(150, scores.get(1).getPoints());
        assertEquals(date, scores.get(1).getPlayedAt());

        assertEquals("mines",scores.get(2).getGame());
        assertEquals("Lukas", scores.get(2).getUsername());
        assertEquals(100, scores.get(2).getPoints());
        assertEquals(date, scores.get(2).getPlayedAt());

        assertEquals("mines",scores.get(3).getGame());
        assertEquals("Lubica", scores.get(3).getUsername());
        assertEquals(85, scores.get(3).getPoints());
        assertEquals(date, scores.get(3).getPlayedAt());

        assertEquals("mines",scores.get(4).getGame());
        assertEquals("Anna", scores.get(4).getUsername());
        assertEquals(55, scores.get(4).getPoints());
        assertEquals(date, scores.get(4).getPlayedAt());
    }
}
