package Dao;

import domain.User;
import domain.UserExercise;
import org.hibernate.query.Query;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.*;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }
    public boolean checkPassword(String login, String password) {
        beginTransaction();
        Query query = session.createQuery("from User where login = :arg1 and password = :arg2");
        query.setParameter("arg1", login);
        query.setParameter("arg2", password);
        boolean temp = query.list().isEmpty();
        commit();

        if (temp)
            return false;
        else
            return true;
    }
    public ArrayList<UserExercise> getUserExercisesByTime(User user, DateTime start, DateTime end) {
        ArrayList<UserExercise> result;
        beginTransaction();
        Query query = session.createQuery("from UserExercise where usersByUserId = :user and unixtimeDate >= :start and unixtimeDate <= :end");
        query.setParameter("user", user);
        query.setParameter("start", start.getMillis() / 1000);
        query.setParameter("end", end.getMillis() / 1000);
        result = (ArrayList<UserExercise>)query.list();
        commit();
        return result;
    }
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DateTime start = new DateTime(2018, 5,10,0,0);
        DateTime end = new DateTime(2018, 5,12,0,0);
        ArrayList<UserExercise> temp = userDao.getUserExercisesByTime(user, start, end);

        System.out.println(start.getMillis() / 1000);
        System.out.println(end.getMillis() / 1000);
    }
}
