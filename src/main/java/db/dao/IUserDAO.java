package db.dao;

import pojo.User;

public interface IUserDAO {
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
    int getUserId(String login, String password);
    String getUserRole(String login, String password);
}
