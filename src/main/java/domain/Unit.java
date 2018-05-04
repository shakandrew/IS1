package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Units", schema = "main", catalog = "")
public class Unit {
    private Long unitId;
    private String name;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(unitId, unit.unitId) &&
                Objects.equals(name, unit.name) &&
                Objects.equals(note, unit.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(unitId, name, note);
    }

    public void fillData(String name, String note) {
        this.setName(name);
        this.setNote(note);
    }
}
