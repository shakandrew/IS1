import Dao.*;
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
        profile.setFirstName("juan");
        profile.setSecondName("conzales");
        profile.setLanguagesByLanguageId(language);
        profile.setSexesBySexId(sex);
        profile.setUnitsByUnitId(unit);
        profile.setHeight((long)200);
        profile.setWeight((long)60);
        profilesDao.insert(profile);

        UserDao userDao = new UserDao();
        User user = new User();
        user.setLogin("juan228");
        user.setPassword("123");
        user.setProfilesByProfileId(profile);
        userDao.insert(user);
    }
}