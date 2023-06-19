package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalStaff {

    @Id
    @Column(nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    @JsonProperty("hospital_id")
    private Hospital hospital;

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_doctor")
    private float outOfWorkRatioDoctor;

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_nurse")
    private float outOfWorkRationNurse;

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_other")
    private float outOfWorkRatioOther;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;

    public HospitalStaff(long id, Hospital hospital, float outOfWorkRatioDoctor, float outOfWorkRationNurse, float outOfWorkRatioOther, Date updatedAt, Date publishedOn) {
        this.id = id;
        this.hospital = hospital;
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
        this.outOfWorkRationNurse = outOfWorkRationNurse;
        this.outOfWorkRatioOther = outOfWorkRatioOther;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public HospitalStaff(long id) {
        this.id = id;
    }

    public HospitalStaff() {
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

    public float getOutOfWorkRatioDoctor() {
        return outOfWorkRatioDoctor;
    }

    public void setOutOfWorkRatioDoctor(float outOfWorkRatioDoctor) {
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
    }

    public float getOutOfWorkRationNurse() {
        return outOfWorkRationNurse;
    }

    public void setOutOfWorkRationNurse(float outOfWorkRationNurse) {
        this.outOfWorkRationNurse = outOfWorkRationNurse;
    }

    public float getOutOfWorkRatioOther() {
        return outOfWorkRatioOther;
    }

    public void setOutOfWorkRatioOther(float outOfWorkRatioOther) {
        this.outOfWorkRatioOther = outOfWorkRatioOther;
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
        return "HospitalStaff{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", outOfWorkRatioDoctor=" + outOfWorkRatioDoctor +
                ", outOfWorkRationNurse=" + outOfWorkRationNurse +
                ", outOfWorkRatioOther=" + outOfWorkRatioOther +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
