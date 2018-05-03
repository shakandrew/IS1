package Dao;

import domain.Sex;
import org.hibernate.query.Query;

/**
 * Created by Eoller on 03-May-18.
 */
public class SexDao extends AbstractDao<Sex> {

    public SexDao() {
        super(Sex.class);
    }

    public Sex getByName(String name){
        beginTransaction();
        Query query = session.createQuery("from Sex where name = :curr");
        query.setParameter("curr", name);
        Sex singleResult = (Sex) query.list().get(0);
        commit();
        return singleResult;
    }

    public static void main(String[] args) {
        SexDao sexDao = new SexDao();
        Sex sex2 = sexDao.getByName("Male");
        System.out.println(sex2.getName() + " " + sex2.getNotes());

    }

}
