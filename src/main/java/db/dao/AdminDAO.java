package db.dao;

import classes.Admin;
import db.ConnectionManagerPostresSQL;
import db.IConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAbstractDAO<Admin> {
    public static class AdminDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostresSQL.getInstance();
    }

    @Override
    public List<Admin> getAll() throws AdminDAOException {
        List<Admin> adminList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin");
            while (resultSet.next()) {
                Admin admin = new Admin(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
        return adminList;
    }

    @Override
    public Admin getByID(int id) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM admin WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Admin(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE admin SET login = ?, password = ? WHERE id = ? ");
    }

    @Override
    public void update(Admin admin) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setString(1, admin.getLogin());
            statement.setString(2, admin.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
    }

    @Override
    public void updateAll(List<Admin> adminList) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Admin admin : adminList) {
                statement.setString(1, admin.getLogin());
                statement.setString(2, admin.getPassword());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE admin WHERE id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "INSERT INTO admin (id, login, password) VALUES (?, ?, ?)");
    }

    @Override
    public void insertOne(Admin admin) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, admin.getIdAdmin());
            statement.setString(2, admin.getLogin());
            statement.setString(3, admin.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }

    }

    @Override
    public void insertAll(List<Admin> adminList) throws AdminDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Admin admin : adminList) {
                statement.setInt(1, admin.getIdAdmin());
                statement.setString(2, admin.getLogin());
                statement.setString(3, admin.getPassword());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AdminDAOException();
        }
    }
}
