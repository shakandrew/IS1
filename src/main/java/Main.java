import Dao.UnitDao;
import Utils.HibernateUtils;
import domain.Unit;
import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {
        UnitDao unitDao = new UnitDao();
        Unit unit = new Unit();
        unit.setName("Piskowaja");
        unit.setNote("PW system");
        unitDao.insert(unit);
    }
}