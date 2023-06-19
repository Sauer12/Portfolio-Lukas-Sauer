package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@Entity
public class District {
    @Id
    @Column(nullable = false)
    private int id;
    @JsonProperty("region_id")
    @ManyToOne
    @JoinColumn(name = "Region.id", nullable = false)
    private Region region;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;

//    @OneToMany(mappedBy = "id")
//    private List<City> cities;
//
//    @OneToMany(mappedBy = "id")
//    private List<DistrictAgTests> districtAgTests;
//
//    @OneToMany(mappedBy = "id")
//    private List<DistrictHospitalBeds> districtHospitalBeds;
//
//    @OneToMany(mappedBy = "id")
//    private List<DistrictHospitalPatients> districtHospitalPatients;

    public District(int id, Region region, String title, String code) {
        this.id = id;
        this.region = region;
        this.title = title;
        this.code = code;
    }

    public District(int id){
        this.id = id;
    }

    public District() {
    }

    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", region=" + region +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

