package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Sexes", schema = "main", catalog = "")
public class Sex {
    private Long sexId;
    private String name;
    private String notes;

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
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sex sex = (Sex) o;
        return Objects.equals(sexId, sex.sexId) &&
                Objects.equals(name, sex.name) &&
                Objects.equals(notes, sex.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sexId, name, notes);
    }
}
