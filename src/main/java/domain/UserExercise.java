package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User_Exercises", schema = "main", catalog = "")
public class UserExercise {
    private Long userExerciseId;
    private Long unixtimeDate;
    private Long setNum;
    private Long exerciseInSetNum;
    private Boolean status;
    private User usersByUserId;
    private Exercise exercisesByExerciseId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_exercise_id")
    public Long getUserExerciseId() {
        return userExerciseId;
    }

    public void setUserExerciseId(Long userExerciseId) {
        this.userExerciseId = userExerciseId;
    }

    @Basic
    @Column(name = "unixtime_date")
    public Long getUnixtimeDate() {
        return unixtimeDate;
    }

    public void setUnixtimeDate(Long unixtimeDate) {
        this.unixtimeDate = unixtimeDate;
    }

    @Basic
    @Column(name = "set_num")
    public Long getSetNum() {
        return setNum;
    }

    public void setSetNum(Long setNum) {
        this.setNum = setNum;
    }

    @Basic
    @Column(name = "exercise_in_set_num")
    public Long getExerciseInSetNum() {
        return exerciseInSetNum;
    }

    public void setExerciseInSetNum(Long exerciseInSetNum) {
        this.exerciseInSetNum = exerciseInSetNum;
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
        UserExercise that = (UserExercise) o;
        return Objects.equals(userExerciseId, that.userExerciseId) &&
                Objects.equals(unixtimeDate, that.unixtimeDate) &&
                Objects.equals(setNum, that.setNum) &&
                Objects.equals(exerciseInSetNum, that.exerciseInSetNum) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userExerciseId, unixtimeDate, setNum, exerciseInSetNum, status);
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
    @JoinColumn(name = "exercise_id", referencedColumnName = "exercise_id", nullable = false)
    public Exercise getExercisesByExerciseId() {
        return exercisesByExerciseId;
    }

    public void setExercisesByExerciseId(Exercise exercisesByExerciseId) {
        this.exercisesByExerciseId = exercisesByExerciseId;
    }

    public void fillData(User user, Exercise exercise, long unixtimeDate,
                         long setNum, long exerciseInSetNum, boolean status) {
        this.setUsersByUserId(user);
        this.setExercisesByExerciseId(exercise);
        this.setUnixtimeDate(unixtimeDate);
        this.setSetNum(setNum);
        this.setExerciseInSetNum(exerciseInSetNum);
        this.setStatus(status);
    }
}
