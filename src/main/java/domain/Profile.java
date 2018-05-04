package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Profiles", schema = "main", catalog = "")
public class Profile {
    private Long profileId;
    private Long weight;
    private Long height;
    private String firstName;
    private String secondName;
    private Sex sexesBySexId;
    private Unit unitsByUnitId;
    private Language languagesByLanguageId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Basic
    @Column(name = "weight")
    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "height")
    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(profileId, profile.profileId) &&
                Objects.equals(weight, profile.weight) &&
                Objects.equals(height, profile.height) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(secondName, profile.secondName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(profileId, weight, height, firstName, secondName);
    }

    @ManyToOne
    @JoinColumn(name = "sex_id", referencedColumnName = "sex_id", nullable = false)
    public Sex getSexesBySexId() {
        return sexesBySexId;
    }

    public void setSexesBySexId(Sex sexesBySexId) {
        this.sexesBySexId = sexesBySexId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false)
    public Unit getUnitsByUnitId() {
        return unitsByUnitId;
    }

    public void setUnitsByUnitId(Unit unitsByUnitId) {
        this.unitsByUnitId = unitsByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    public Language getLanguagesByLanguageId() {
        return languagesByLanguageId;
    }

    public void setLanguagesByLanguageId(Language languagesByLanguageId) {
        this.languagesByLanguageId = languagesByLanguageId;
    }

    public void fillData(Sex sex, Unit unit, Language language, long weight,
                         long height, String firstName, String secondName) {
        this.setSexesBySexId(sex);
        this.setUnitsByUnitId(unit);
        this.setLanguagesByLanguageId(language);
        this.setWeight(weight);
        this.setHeight(height);
        this.setFirstName(firstName);
        this.setSecondName(secondName);
    }
}
