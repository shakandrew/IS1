package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Sexes", schema = "main", catalog = "")
public class Sex {
    private Long sexId;
    private String name;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sex_id")
    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        this.sexId = sexId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "notes")
    public String getNote() {
        return note;
    }

    public void setNote(String notes) {
        this.note = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sex sex = (Sex) o;
        return Objects.equals(sexId, sex.sexId) &&
                Objects.equals(name, sex.name) &&
                Objects.equals(note, sex.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sexId, name, note);
    }

    public void fillData(String name, String note) {
        this.setName(name);
        this.setNote(note);
    }
}
