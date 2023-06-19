package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegionVaccinations {
    @Id
    @Column(nullable = false)
    private String id;

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
    @JsonProperty("dose1_sum")
    private int dose1Sum;

    @Column(nullable = false)
    @JsonProperty("dose2_sum")
    private int dose2Sum;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @Column(nullable = false)
    @JsonProperty("published_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;

    public RegionVaccinations(String id, Region region, int dose1Count, int dose2Count, int dose1Sum, int dose2Sum, Date updatedAt, Date publishedOn) {
        this.id = id;
        this.region = region;
        this.dose1Count = dose1Count;
        this.dose2Count = dose2Count;
        this.dose1Sum = dose1Sum;
        this.dose2Sum = dose2Sum;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }
    public RegionVaccinations(String id) {
        this.id = id;
    }

    public RegionVaccinations() {
    }

    public String getId() {
        return id;
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

    public int getDose1Sum() {
        return dose1Sum;
    }

    public void setDose1Sum(int dose1Sum) {
        this.dose1Sum = dose1Sum;
    }

    public int getDose2Sum() {
        return dose2Sum;
    }

    public void setDose2Sum(int dose2Sum) {
        this.dose2Sum = dose2Sum;
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
        return "RegionVaccinations{" +
                "id=" + id +
                ", region=" + region +
                ", dose1Count=" + dose1Count +
                ", dose2Count=" + dose2Count +
                ", dose1Sum=" + dose1Sum +
                ", dose2Sum=" + dose2Sum +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
