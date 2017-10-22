package db.dao;

import db.ConnectionManagerPostgreSQL;
import db.IConnectionManager;
import org.apache.log4j.Logger;
import pojo.Patient;
import pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    public static class UserDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

    @Override
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        logger.info("Log for getAll Users");

        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return userList;
    }

    @Override
    public int getUserId(String login, String password) {
        int index = 0;
        logger.info("Log for get User identifier by login and password");

        PreparedStatement statement = null;
        try {
            statement = manager.getConnection()
                                            .prepareStatement("SELECT id FROM users WHERE login = ? AND password = ?");

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();
            index = resultSet.getInt("id");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return index;
    }

    @Override
    public String getUserRole(String login, String password) {
        String role = "";

        logger.info("Log for get User Role by login and password");

        PreparedStatement statement = null;
        try {
            statement = manager.getConnection()
                    .prepareStatement("SELECT role FROM users WHERE login = ? AND password = ?");

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();
            role = resultSet.getString("role");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return role;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        User user = null;

        logger.info("Log for get User object by login and password");

        try {
            PreparedStatement statement = manager.getConnection().
                prepareStatement("SELECT * FROM users WHERE login = ? AND  password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getString("role"));
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return user;
    }

    @Override
    public Boolean createUser(User user) {
        logger.info("Log for create User");
        
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                ("INSERT INTO users (login, password, role) VALUES(?, ?, 'patient')");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            if (statement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return false;
    }
}

