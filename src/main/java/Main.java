import Dao.*;
import GUI.ExampleForm;
import Utils.HibernateUtils;
import domain.*;
import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.joda.time.DateTime;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class Main {
    public static void main(final String[] args) throws Exception {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        WeekPlan weekPlan = new WeekPlan(user, new DateTime());
        System.out.println("Piska");
    }
}