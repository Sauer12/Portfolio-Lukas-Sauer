package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SlovakiaHospitalBeds {
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

    @Column(nullable = false)
    @JsonProperty("capacity_all")
    private int capacityAll;
    // Maximálny počet všetkých lôžok (pre COVID aj neCOVID pacientov)

    @Column(nullable = false)
    @JsonProperty("free_all")
    private int freeAll;
    //Počet všetkých voľných lôžok

    @Column(nullable = false)
    @JsonProperty("capacity_covid")
    private int capacityCovid;
    // Maximálny počet reprofilovaných lôžok pre COVID pacientov

    @Column(nullable = false)
    @JsonProperty("occupied_jis_covid")
    private int occupiedJisCovid;
    // Lôžka na jednotke intenzívnej starostlivosti (JIS) aktuálne využité pacientami, ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_oaim_covid")
    private int occupiedOaimCovid;
    // Lôžka na oddelení anesteziológie a intenzívnej medicíny (OAIM), aktuálne využité ventilovanými pacientami, ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_o2_covid")
    private int occupiedO2Covid;
    // Lôžka s kyslíkom (O2) aktuálne využité pacientami, ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_other_covid")
    private int occupiedOtherCovid;
    // Obyčajné lôžka aktuálne využité pacientami, ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    // Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého z atribútov záznamu) - example: 2020-01-13 12:34:56


    public SlovakiaHospitalBeds(long id, Date oldestReportedAt, Date newestReportedAt, Date publishedOn, int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid, int occupiedOaimCovid, int occupiedO2Covid, int occupiedOtherCovid, Date updatedAt) {
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupiedO2Covid = occupiedO2Covid;
        this.occupiedOtherCovid = occupiedOtherCovid;
        this.updatedAt = updatedAt;
    }

    public SlovakiaHospitalBeds(long id) {
        this.id = id;
    }

    public SlovakiaHospitalBeds() {

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

    public int getCapacityAll() {
        return capacityAll;
    }

    public void setCapacityAll(int capacityAll) {
        this.capacityAll = capacityAll;
    }

    public int getFreeAll() {
        return freeAll;
    }

    public void setFreeAll(int freeAll) {
        this.freeAll = freeAll;
    }

    public int getCapacityCovid() {
        return capacityCovid;
    }

    public void setCapacityCovid(int capacityCovid) {
        this.capacityCovid = capacityCovid;
    }

    public int getOccupiedJisCovid() {
        return occupiedJisCovid;
    }

    public void setOccupiedJisCovid(int occupiedJisCovid) {
        this.occupiedJisCovid = occupiedJisCovid;
    }

    public int getOccupiedOaimCovid() {
        return occupiedOaimCovid;
    }

    public void setOccupiedOaimCovid(int occupiedOaimCovid) {
        this.occupiedOaimCovid = occupiedOaimCovid;
    }

    public int getOccupiedO2Covid() {
        return occupiedO2Covid;
    }

    public void setOccupiedO2Covid(int occupiedO2Covid) {
        this.occupiedO2Covid = occupiedO2Covid;
    }

    public int getOccupiedOtherCovid() {
        return occupiedOtherCovid;
    }

    public void setOccupiedOtherCovid(int occupiedOtherCovid) {
        this.occupiedOtherCovid = occupiedOtherCovid;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "SlovakiaHospitalBeds{" +
                "id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", capacityAll=" + capacityAll +
                ", freeAll=" + freeAll +
                ", capacityCovid=" + capacityCovid +
                ", occupiedJisCovid=" + occupiedJisCovid +
                ", occupiedOaimCovid=" + occupiedOaimCovid +
                ", occupiedO2Covid=" + occupiedO2Covid +
                ", occupiedOtherCovid=" + occupiedOtherCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
