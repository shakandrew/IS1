package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Languages", schema = "main", catalog = "")
public class Language {
    private Long languageId;
    private String name;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
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
        Language language = (Language) o;
        return Objects.equals(languageId, language.languageId) &&
                Objects.equals(name, language.name) &&
                Objects.equals(note, language.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(languageId, name, note);
    }

    public void fillData(String name, String note) {
        this.setName(name);
        this.setNote(note);
    }
}
