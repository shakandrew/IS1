package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Exercises", schema = "main", catalog = "")
public class Exercise {
    private Long exerciseId;
    private String name;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
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
        Exercise exercise = (Exercise) o;
        return Objects.equals(exerciseId, exercise.exerciseId) &&
                Objects.equals(name, exercise.name) &&
                Objects.equals(note, exercise.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(exerciseId, name, note);
    }


    public void fillData(String name, String note) {
        this.setName(name);
        this.setNote(note);
    }
}
