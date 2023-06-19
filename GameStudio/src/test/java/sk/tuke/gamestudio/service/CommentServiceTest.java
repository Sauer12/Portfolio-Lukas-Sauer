package sk.tuke.gamestudio.service;

import org.junit.Test;
import sk.tuke.gamestudio.entity.Comment;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentServiceTest {
    private final CommentService commentService = new CommentServiceJdbc();

    @Test
    public void testReset(){
        commentService.addComment(new Comment("Mines", "Lukas", "Toto je testovaci komentar", new Date()));
        commentService.reset();
        assertEquals(0, commentService.getComments("Mines").size());
    }

    @Test
    public void testAddScore(){
        commentService.reset();
        var date = new Date();
        final String gameName = "Mines";

        commentService.addComment(new Comment(gameName, "Jano", "testovaci koemntar", date));

        var comments = commentService.getComments("Mines");

        assertEquals(1, comments.size());
        assertEquals(gameName, comments.get(0).getGame());
        assertEquals("Jano", comments.get(0).getUsername());
        assertEquals("testovaci koemntar", comments.get(0).getComment());
        assertEquals(date, comments.get(0).getCommented_at());
    }

    @Test
    public void testGetComments(){
        commentService.reset();

        var date = new Date();
        commentService.addComment(new Comment("Mines", "Karol", "Testovaci koment n1", Timestamp.valueOf("2022-09-07 09:21:46.659")));
        commentService.addComment(new Comment("Mines", "Peter", "Testovaci koment n2", Timestamp.valueOf("2022-09-08 09:21:46.659")));
        commentService.addComment(new Comment("Mines", "Marek", "Testovaci koment n3", Timestamp.valueOf("2022-09-09 09:21:46.659")));
        commentService.addComment(new Comment("Mines", "Anna", "Testovaci koment n4", Timestamp.valueOf("2022-09-11 09:21:46.659")));
        commentService.addComment(new Comment("Mines", "Karolina", "Testovaci koment n5", Timestamp.valueOf("2022-09-10 09:21:46.659")));

        var comments = commentService.getComments("Mines");

        assertEquals(5, commentService.getComments("Mines").size());

        assertEquals("Mines",comments.get(0).getGame());
        assertEquals("Karol", comments.get(0).getUsername());
        assertEquals("Testovaci koment n1", comments.get(0).getComment());
        assertEquals(Timestamp.valueOf("2022-09-07 09:21:46.659"), comments.get(0).getCommented_at());

        assertEquals("Mines",comments.get(1).getGame());
        assertEquals("Peter", comments.get(1).getUsername());
        assertEquals("Testovaci koment n2", comments.get(1).getComment());
        assertEquals(Timestamp.valueOf("2022-09-08 09:21:46.659"), comments.get(1).getCommented_at());

        assertEquals("Mines",comments.get(2).getGame());
        assertEquals("Marek", comments.get(2).getUsername());
        assertEquals("Testovaci koment n3", comments.get(2).getComment());
        assertEquals(Timestamp.valueOf("2022-09-09 09:21:46.659"), comments.get(2).getCommented_at());

        assertEquals("Mines",comments.get(3).getGame());
        assertEquals("Karolina", comments.get(3).getUsername());
        assertEquals("Testovaci koment n5", comments.get(3).getComment());
        assertEquals(Timestamp.valueOf("2022-09-10 09:21:46.659"), comments.get(3).getCommented_at());

        assertEquals("Mines",comments.get(4).getGame());
        assertEquals("Anna", comments.get(4).getUsername());
        assertEquals("Testovaci koment n4", comments.get(4).getComment());
        assertEquals(Timestamp.valueOf("2022-09-11 09:21:46.659"), comments.get(4).getCommented_at());
    }
}
