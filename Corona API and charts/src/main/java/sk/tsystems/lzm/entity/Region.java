package sk.tsystems.lzm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Region {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String abbreviation;

 /*   @OneToMany
    private List<RegionVaccinations> regionVaccinations;*/

    public Region(int id, String title, String code, String abbreviation) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.abbreviation = abbreviation;
    }

    public Region(int id){ this.id = id; }

    public Region() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
