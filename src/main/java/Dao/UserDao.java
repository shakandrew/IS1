package Dao;

import domain.User;
import org.hibernate.query.Query;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }
    public boolean checkPassword(String login, String password) {
        beginTransaction();
        Query query = session.createQuery("from User where login = :arg1 and password = :arg2");
        query.setParameter("arg1", login);
        query.setParameter("arg2", password);
        if (query.list().isEmpty())
            return false;
        else
            return true;

    }
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        String login = "admin";
        String password = "admin1";
        if (userDao.checkPassword(login, password))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
