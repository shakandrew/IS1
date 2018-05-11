package domain;

import Dao.UserDao;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class DayPlan {

    private DateTime date;
    private ArrayList<UserExercise> userExercises;

    public DayPlan(User user, DateTime date) {
        this.date = new DateTime(date);
        DateTime start = new DateTime(date.getYear(), date.getMonthOfYear(),
                date.getDayOfMonth(), 0,0);
        DateTime end = new DateTime(date.getYear(), date.getMonthOfYear(),
                date.getDayOfMonth(), 23,59);
        UserDao userDao = new UserDao();
        this.userExercises = userDao.getUserExercisesByTime(user, start, end);
    }
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public ArrayList<UserExercise> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(ArrayList<UserExercise> userExercises) {
        this.userExercises = userExercises;
    }

}
