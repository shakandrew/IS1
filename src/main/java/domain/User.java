package domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "main", catalog = "")
public class User {
    private Long userId;
    private String login;
    private String password;
    private Collection<UserAchievement> userAchievementsByUserId;
    private Collection<UserExercise> userExercisesByUserId;
    private Profile profilesByProfileId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, login, password);
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserAchievement> getUserAchievementsByUserId() {
        return userAchievementsByUserId;
    }

    public void setUserAchievementsByUserId(Collection<UserAchievement> userAchievementsByUserId) {
        this.userAchievementsByUserId = userAchievementsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserExercise> getUserExercisesByUserId() {
        return userExercisesByUserId;
    }

    public void setUserExercisesByUserId(Collection<UserExercise> userExercisesByUserId) {
        this.userExercisesByUserId = userExercisesByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)
    public Profile getProfilesByProfileId() {
        return profilesByProfileId;
    }

    public void setProfilesByProfileId(Profile profilesByProfileId) {
        this.profilesByProfileId = profilesByProfileId;
    }
}
