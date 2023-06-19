package sk.tuke.gamestudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentWebServiceREST {
    @Autowired
    private CommentService commentService;

        // localhost:8080/api/score
        //post
        //novy objekt je v tele spravy
    @PostMapping
    void addScore(@RequestBody Comment comment){
        commentService.addComment(comment);
    }

        // localhost:8080/api/score/game
        //get
    @GetMapping("/{game}")
    List<Comment> getComments(@PathVariable String game){
        return commentService.getComments(game);
    }
}
