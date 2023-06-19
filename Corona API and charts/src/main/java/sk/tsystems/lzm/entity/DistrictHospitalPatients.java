package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DistrictHospitalPatients {
    @Id
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    @JsonProperty("oldest_reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date oldestReportedAt;
    // Najstarší čas, kedy niektorá nemocnica reportovala záznam v agregácii- example: 2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("newest_reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newestReportedAt;
    // Najnovší čas, kedy niektorá nemocnica reportovala záznam v agregácii - example: 2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;
    //Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík - example: 2020-01-13

    @ManyToOne
    @JoinColumn(name="District.id")
    private District district;
    //Interné id okresu z /api/districts alebo null. Hodnota null znamená, že dáta nie sú priradené žiadnemu okresu.

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


    public DistrictHospitalPatients(long id, Date oldestReportedAt, Date newestReportedAt, Date publishedOn, District district, int ventilatedCovid, int nonCovid, int confirmedCovid, int suspectedCovid, Date updatedAt) {
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.district = district;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
    }
    public DistrictHospitalPatients(long id) {
        this.id = id;
    }

    public DistrictHospitalPatients() {

    }

    public long getId() {
        return id;
    }


    public Date getOldestReportedAt() {
        return oldestReportedAt;
    }

    public void setOldestReportedAt(Date oldestReportedAt) {
        this.oldestReportedAt = oldestReportedAt;
    }

    public Date getNewestReportedAt() {
        return newestReportedAt;
    }

    public void setNewestReportedAt(Date newestReportedAt) {
        this.newestReportedAt = newestReportedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    @Override
    public String toString() {
        return "DistrictHospitalPatients{" +
                "id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", district=" + district +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
