package db.dao;

import pojo.User;

public interface IUserDAO {
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
}
