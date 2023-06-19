package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vaccinations {

    @Id
    @Column(nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "Vaccine.id", nullable = false)
    @JsonProperty("vaccine_id")
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "Region.id")
    @JsonProperty("region_id")
    private Region region;

    @Column(nullable = false)
    @JsonProperty("dose1_count")
    private int dose1Count;

    @Column(nullable = false)
    @JsonProperty("dose2_count")
    private int dose2Count;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    private Date updatedAt;

    @Column(nullable = false)
    @JsonProperty("published_on")
    private Date publishedOn;

    public Vaccinations(String id, Vaccine vaccine, Region region, int dose1Count, int dose2Count, Date updatedAt, Date publishedOn) {
        this.id = id;
        this.vaccine = vaccine;
        this.region = region;
        this.dose1Count = dose1Count;
        this.dose2Count = dose2Count;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public Vaccinations(String id) {
        this.id = id;
    }

    public Vaccinations() {
    }

    public String getId() {
        return id;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getDose1Count() {
        return dose1Count;
    }

    public void setDose1Count(int dose1Count) {
        this.dose1Count = dose1Count;
    }

    public int getDose2Count() {
        return dose2Count;
    }

    public void setDose2Count(int dose2Count) {
        this.dose2Count = dose2Count;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Override
    public String toString() {
        return "Vaccinations{" +
                "id=" + id +
                ", vaccine=" + vaccine +
                ", region=" + region +
                ", dose1Count=" + dose1Count +
                ", dose2Count=" + dose2Count +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
