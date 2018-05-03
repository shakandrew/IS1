package Dao;

import Utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by Eoller on 03-May-18.
 */
public abstract class AbstractDao<T> {

    protected Session session;

    private Class entityBeanType;

    public AbstractDao(Class type) {
        entityBeanType = type;
    }

    public void insert(T toInsert){
        beginTransaction();
        session.save(toInsert);
        commit();
    }

    public List<T> getAll(){
        beginTransaction();
        List resultList = session.createQuery("from " + entityBeanType.getName()).list();
        commit();
        return resultList;
    }

    public T getById(long id){
        beginTransaction();
        Object o = session.get(entityBeanType, id);
        commit();
        return (T) o;
    }

    public void delete(long id){
        beginTransaction();
        Object o = session.get(entityBeanType, id);
        session.delete((T) o);
        commit();
    }

    public void update(T toUpdate){
        beginTransaction();
        session.update(toUpdate);
        commit();
    }

    protected void beginTransaction(){
        session = HibernateUtils.getSession();
        session.beginTransaction();
    }

    protected void commit(){
        session.getTransaction().commit();
    }
}
