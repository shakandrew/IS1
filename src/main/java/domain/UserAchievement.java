package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User_Achievements", schema = "main", catalog = "")
public class UserAchievement {
    private Long userAchievementId;
    private Boolean status;
    private User usersByUserId;
    private Achievement achievementsByAchievementId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_achievement_id")
    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAchievement that = (UserAchievement) o;
        return Objects.equals(userAchievementId, that.userAchievementId) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userAchievementId, status);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "achievement_id", referencedColumnName = "achievement_id", nullable = false)
    public Achievement getAchievementsByAchievementId() {
        return achievementsByAchievementId;
    }

    public void setAchievementsByAchievementId(Achievement achievementsByAchievementId) {
        this.achievementsByAchievementId = achievementsByAchievementId;
    }

    public void fillData(User user, Achievement achievement, boolean status) {
        this.setUsersByUserId(user);
        this.setAchievementsByAchievementId(achievement);
        this.setStatus(status);
    }
}
