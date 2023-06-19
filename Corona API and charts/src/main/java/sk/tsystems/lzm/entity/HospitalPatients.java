package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalPatients {

    @Id
    @Column(nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name="Hospital.id", nullable = false)
    private Hospital hospital;
    // Interné id nemocnice z /api/hospitals

    @Column(nullable = false)
    @JsonProperty("reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportedAt;
    // Čas, kedy záznam reportovala nemocnica - example: 2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("ventilated_covid")
    private int ventilatedCovid;
    //Počet pacientov, ktorí majú COVID a sú na pľúcnej ventilácii

    @Column(nullable = false)
    @JsonProperty("non_covid")
    private int nonCovid;
    // Počet pacientov, ktorí nemajú potvrdený COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    @JsonProperty("confirmed_covid")
    private int confirmedCovid;
    // Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    @JsonProperty("suspected_covid")
    private int suspectedCovid;
    // Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    // Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého z atribútov záznamu)- example: 2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;
    // Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík- example: 2020-01-13


    public HospitalPatients(long id, Hospital hospital, Date reportedAt, int ventilatedCovid, int nonCovid, int confirmedCovid, int suspectedCovid, Date updatedAt, Date publishedOn) {
        this.id = id;
        this.hospital = hospital;
        this.reportedAt = reportedAt;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public HospitalPatients(long id) {
        this.id = id;
    }

    public HospitalPatients() {

    }

    public long getId() {
        return id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
    }

    public int getVentilatedCovid() {
        return ventilatedCovid;
    }

    public void setVentilatedCovid(int ventilatedCovid) {
        this.ventilatedCovid = ventilatedCovid;
    }

    public int getNonCovid() {
        return nonCovid;
    }

    public void setNonCovid(int nonCovid) {
        this.nonCovid = nonCovid;
    }

    public int getConfirmedCovid() {
        return confirmedCovid;
    }

    public void setConfirmedCovid(int confirmedCovid) {
        this.confirmedCovid = confirmedCovid;
    }

    public int getSuspectedCovid() {
        return suspectedCovid;
    }

    public void setSuspectedCovid(int suspectedCovid) {
        this.suspectedCovid = suspectedCovid;
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
        return "HospitalPatients{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", reportedAt=" + reportedAt +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
