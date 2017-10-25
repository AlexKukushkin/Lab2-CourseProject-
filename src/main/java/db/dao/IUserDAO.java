package db.dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers() throws SQLException;
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
    int getUserId(String login, String password);
    String getUserRole(String login, String password);
}
