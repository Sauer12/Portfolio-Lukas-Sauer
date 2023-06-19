package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class VaccinationContacts implements Serializable {

    @OneToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    @Id
    @JsonProperty("hospital_id")
    private Hospital hospital;

    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    @JsonProperty("substitutes_emails")
    private List<String> getSubstitutesPhones;

    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    @JsonProperty("substitutes_emails")
    private List<String> substitutesEmails;

    @Column(nullable = false)
    @JsonProperty("substitutes_link")
    private String substitutesLink;

    @Column(nullable = false)
    @JsonProperty("substitutes_note")
    private String substitutesNote;

    @Column(nullable = false)
    @JsonProperty("is_accepting_new_registration")
    private boolean isAcceptingNewRegistration;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public VaccinationContacts(Hospital hospital, List<String> getSubstitutesPhones, List<String> substitutesEmails, String substitutesLink, String substitutesNote, boolean isAcceptingNewRegistration, Date updatedAt) {
        this.hospital = hospital;
        this.getSubstitutesPhones = getSubstitutesPhones;
        this.substitutesEmails = substitutesEmails;
        this.substitutesLink = substitutesLink;
        this.substitutesNote = substitutesNote;
        this.isAcceptingNewRegistration = isAcceptingNewRegistration;
        this.updatedAt = updatedAt;
    }

    public VaccinationContacts() {
    }

    public Hospital getHospital() {
        return hospital;
    }

    public List<String> getGetSubstitutesPhones() {
        return getSubstitutesPhones;
    }

    public void setGetSubstitutesPhones(List<String> getSubstitutesPhones) {
        this.getSubstitutesPhones = getSubstitutesPhones;
    }

    public List<String> getSubstitutesEmails() {
        return substitutesEmails;
    }

    public void setSubstitutesEmails(List<String> substitutesEmails) {
        this.substitutesEmails = substitutesEmails;
    }

    public String getSubstitutesLink() {
        return substitutesLink;
    }

    public void setSubstitutesLink(String substitutesLink) {
        this.substitutesLink = substitutesLink;
    }

    public String getSubstitutesNote() {
        return substitutesNote;
    }

    public void setSubstitutesNote(String substitutesNote) {
        this.substitutesNote = substitutesNote;
    }

    public boolean isAcceptingNewRegistration() {
        return isAcceptingNewRegistration;
    }

    public void setAcceptingNewRegistration(boolean acceptingNewRegistration) {
        isAcceptingNewRegistration = acceptingNewRegistration;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "VaccinationContacts{" +
                "hospital=" + hospital +
                ", getSubstitutesPhones=" + getSubstitutesPhones +
                ", substitutesEmails=" + substitutesEmails +
                ", substitutesLink='" + substitutesLink + '\'' +
                ", substitutesNote='" + substitutesNote + '\'' +
                ", isAcceptingNewRegistration=" + isAcceptingNewRegistration +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
