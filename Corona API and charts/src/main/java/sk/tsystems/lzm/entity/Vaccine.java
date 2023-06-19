package sk.tsystems.lzm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vaccine {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String title;
    //Názov vakcíny

    @Column(nullable = false)
    private String manufacturer;
    //Výrobca vakcíny

    //konstruktor
    public Vaccine(int id, String title, String manufacturer) {
        this.id = id;
        this.title = title;
        this.manufacturer = manufacturer;
    }

    public Vaccine(int id) {
        this.id = id;
    }

    //prazdny konstruktor
    public Vaccine() {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
