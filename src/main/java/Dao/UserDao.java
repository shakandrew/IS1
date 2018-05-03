package Dao;

import domain.User;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }
}
