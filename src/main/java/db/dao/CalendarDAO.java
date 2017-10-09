package db.dao;

import classes.Calendar;
import db.ConnectionManagerPostresSQL;
import db.IConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalendarDAO implements IAbstractDAO<Calendar> {
    public static class CalendarDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostresSQL.getInstance();
    }

    @Override
    public List<Calendar> getAll() throws CalendarDAOException {
        List<Calendar> calendarList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM calendar");
            while (resultSet.next()) {
                Calendar calendar = new Calendar(
                        resultSet.getInt("id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getString("monday"),
                        resultSet.getString("tuesday"),
                        resultSet.getString("wednesday"),
                        resultSet.getString("thursday"),
                        resultSet.getString("friday"),
                        resultSet.getString("saturday"),
                        resultSet.getString("sunday"));
                        calendarList.add(calendar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
        return calendarList;
    }

    @Override
    public Calendar getByID(int id) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM calendar WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Calendar(
                    resultSet.getInt("id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getString("monday"),
                    resultSet.getString("tuesday"),
                    resultSet.getString("wednesday"),
                    resultSet.getString("thursday"),
                    resultSet.getString("friday"),
                    resultSet.getString("saturday"),
                    resultSet.getString("sunday"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE calendar SET doctor_id = ?, monday = ?, tuesday = ?, " +
                        "wednesday = ?, thursday = ?, friday = ?, saturday = ?, sunday = ? WHERE id = ?");
    }

    @Override
    public void update(Calendar calendar) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setInt(1, calendar.getIdCalendar());
            statement.setInt(2, calendar.getIdDoctor());
            statement.setString(3, calendar.getMonDay());
            statement.setString(4, calendar.getTuesDay());
            statement.setString(5, calendar.getWednesDay());
            statement.setString(6, calendar.getThursDay());
            statement.setString(7, calendar.getFriDay());
            statement.setString(8, calendar.getSaturDay());
            statement.setString(9, calendar.getSunDay());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }

    @Override
    public void updateAll(List<Calendar> calendarList) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Calendar calendar : calendarList) {
                statement.setInt(1, calendar.getIdCalendar());
                statement.setInt(2, calendar.getIdDoctor());
                statement.setString(3, calendar.getMonDay());
                statement.setString(4, calendar.getTuesDay());
                statement.setString(5, calendar.getWednesDay());
                statement.setString(6, calendar.getThursDay());
                statement.setString(7, calendar.getFriDay());
                statement.setString(8, calendar.getSaturDay());
                statement.setString(9, calendar.getSunDay());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE calendar WHERE id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "INSERT INTO calendar (id, doctor_id, monday, tuesday, wednesday, " +
                        "thursday, friday, saturday, sunday) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Calendar calendar) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, calendar.getIdCalendar());
            statement.setInt(2, calendar.getIdDoctor());
            statement.setString(3, calendar.getMonDay());
            statement.setString(4, calendar.getTuesDay());
            statement.setString(5, calendar.getWednesDay());
            statement.setString(6, calendar.getThursDay());
            statement.setString(7, calendar.getFriDay());
            statement.setString(8, calendar.getSaturDay());
            statement.setString(9, calendar.getSunDay());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }

    }

    @Override
    public void insertAll(List<Calendar> calendarList) throws CalendarDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Calendar calendar : calendarList) {
                statement.setInt(1, calendar.getIdCalendar());
                statement.setInt(2, calendar.getIdDoctor());
                statement.setString(3, calendar.getMonDay());
                statement.setString(4, calendar.getTuesDay());
                statement.setString(5, calendar.getWednesDay());
                statement.setString(6, calendar.getThursDay());
                statement.setString(7, calendar.getFriDay());
                statement.setString(8, calendar.getSaturDay());
                statement.setString(9, calendar.getSunDay());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }
}
