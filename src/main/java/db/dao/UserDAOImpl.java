package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        logger.info("Log for getAll Users");


        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();

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


        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM users WHERE login = ? AND password = ?");

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

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection
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

        try(Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.
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
        
        try(Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement
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

