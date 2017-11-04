package db.dao;

import org.springframework.security.core.userdetails.UserDetails;
import pojo.User;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers() throws SQLException;
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
    int getUserId(String login, String password);
    UserDetails getByUsername(String username);
}
