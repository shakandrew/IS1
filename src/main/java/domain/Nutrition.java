package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Nutritions", schema = "main", catalog = "")
public class Nutrition {
    private Long nutritionId;
    private String name;
    private String note;
    private Long proteinsNum;
    private Long fatsNum;
    private Long carbohydratesNum;
    private String imageUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutrition_id")
    public Long getNutritionId() {
        return nutritionId;
    }

    public void setNutritionId(Long nutritionId) {
        this.nutritionId = nutritionId;
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

    @Basic
    @Column(name = "proteins_num")
    public Long getProteinsNum() {
        return proteinsNum;
    }

    public void setProteinsNum(Long proteinsNum) {
        this.proteinsNum = proteinsNum;
    }

    @Basic
    @Column(name = "fats_num")
    public Long getFatsNum() {
        return fatsNum;
    }

    public void setFatsNum(Long fatsNum) {
        this.fatsNum = fatsNum;
    }

    @Basic
    @Column(name = "carbohydrates_num")
    public Long getCarbohydratesNum() {
        return carbohydratesNum;
    }

    public void setCarbohydratesNum(Long carbohydratesNum) {
        this.carbohydratesNum = carbohydratesNum;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutrition nutrition = (Nutrition) o;
        return Objects.equals(nutritionId, nutrition.nutritionId) &&
                Objects.equals(name, nutrition.name) &&
                Objects.equals(note, nutrition.note) &&
                Objects.equals(proteinsNum, nutrition.proteinsNum) &&
                Objects.equals(fatsNum, nutrition.fatsNum) &&
                Objects.equals(carbohydratesNum, nutrition.carbohydratesNum) &&
                Objects.equals(imageUrl, nutrition.imageUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nutritionId, name, note, proteinsNum, fatsNum, carbohydratesNum, imageUrl);
    }
}
