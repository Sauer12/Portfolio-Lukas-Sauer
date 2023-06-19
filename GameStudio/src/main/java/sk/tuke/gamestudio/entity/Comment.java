package sk.tuke.gamestudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private int identity;
    private String game;
    private String username;
    private String comment;

    private Date commented_at;

    public Comment(String game, String username, String comment, Date commented_at) {
        this.game = game;
        this.username = username;
        this.comment = comment;
        this.commented_at = commented_at;
    }

    public Comment(){}

    public void setGame(String game) {
        this.game = game;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommented_at(Date commented_at) {
        this.commented_at = commented_at;
    }

    public int getIdentity() {
        return identity;
    }

    public String getGame() {
        return game;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public Date getCommented_at() {
        return commented_at;
    }

    public String toString() {
        return username + " commented: " + comment + ". || comment added -> " + commented_at;
    }
}
