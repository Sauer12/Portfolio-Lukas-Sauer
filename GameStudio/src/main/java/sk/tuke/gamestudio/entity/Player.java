package sk.tuke.gamestudio.entity;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private int ident;

    @Column(nullable = false, length = 32, unique = true)
    private String userName;

    @Column(length = 500)
    private String aboutMe;

    @Column(nullable = false)
    private int level;

    @ManyToOne
    @JoinColumn(name = "Country.ident", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "Occupation.ident", nullable = false)
    private Occupation occupation;

    public Player(String userName, String aboutMe, int level, Country country, Occupation occupation) {
        this.userName = userName;
        this.aboutMe = aboutMe;
        this.level = level;
        this.country = country;
        this.occupation = occupation;
    }

    public Player(String userName, Country country, Occupation occupation) {
        this.userName = userName;
        this.country = country;
        this.occupation = occupation;
    }

    public Player(){}

    public int getIdent() {
        return ident;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ident=" + ident +
                ", userName='" + userName + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", level=" + level +
                ", country=" + country +
                ", occupation=" + occupation +
                '}';
    }
}

