import Dao.*;
import GUI.ExampleForm;
import Utils.HibernateUtils;
import domain.*;
import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class Main {
    public static void main(final String[] args) throws Exception {
        LanguageDao languageDao = new LanguageDao();
        Language language = languageDao.getById(1);

        UnitDao unitDao = new UnitDao();
        Unit unit = unitDao.getById(2);

        SexDao sexDao = new SexDao();
        Sex sex = sexDao.getByName("Male");

        ProfilesDao profilesDao = new ProfilesDao();
        Profile profile = new Profile();
        profile.fillData(sex, unit, language, 100, 100, "A", "A");
        profilesDao.insert(profile);

        UserDao userDao = new UserDao();
        User user = new User();
        user.fillData("a1", "a2", profile);
        userDao.insert(user);
    }
}