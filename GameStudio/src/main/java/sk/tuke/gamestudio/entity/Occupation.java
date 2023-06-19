package sk.tuke.gamestudio.entity;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Occupation {
    @Id
    @GeneratedValue
    private int ident;

    @Column(nullable = false, length = 32, unique = true)
    private String occupation;

    public Occupation(String occupation) {
        this.occupation = occupation;
    }

    public Occupation(){}

    public int getIdent() {
        return ident;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return occupation;
    }
}

