package sk.tuke.gamestudio.entity;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Country {
    @Id
    @GeneratedValue
    private int ident;

    @Column(nullable = false, length = 128, unique = true)
    private String country;

    public Country(String country){
        this.country = country;
    }

    public Country(){}

    public int getIdent() {
        return ident;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country;
    }
}



