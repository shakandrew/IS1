package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Achievements", schema = "main", catalog = "")
public class Achievement {
    private Long achievementId;
    private String name;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
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
        Achievement that = (Achievement) o;
        return Objects.equals(achievementId, that.achievementId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(achievementId, name, note);
    }
}
