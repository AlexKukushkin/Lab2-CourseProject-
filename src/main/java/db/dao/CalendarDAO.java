package db.dao;

import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import pojo.Calendar;
import db.TomcatConnectionPool;
import db.IConnectionManager;
import pojo.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarDAO implements IAbstractDAO<Calendar> {
    public static class CalendarDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(CalendarDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<Calendar> getAll() throws CalendarDAOException {
        List<Calendar> calendarList = new ArrayList<>();
        logger.info("Log for getAll Doctors schedules");

        Statement statement = null;

        try (Connection connection = manager.getConnection()){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT calend.*, doc.first_name, doc.family_name, doc.patronymic, " +
                    "doc.specialization, doc.office\n" +
                    "FROM public.\"calendar\" calend LEFT JOIN public.\"doctor\" doc ON calend.\"doctor_id\" = doc.id_doctor;");

            while (resultSet.next()) {
                Calendar calendar = new Calendar(
                        resultSet.getInt("id_calendar"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getString("monday"),
                        resultSet.getString("tuesday"),
                        resultSet.getString("wednesday"),
                        resultSet.getString("thursday"),
                        resultSet.getString("friday"),
                        resultSet.getString("saturday"),
                        resultSet.getString("sunday"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("specialization"),
                        resultSet.getString("office"));
                        calendarList.add(calendar);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CalendarDAOException();
        }
        return calendarList;
    }

    @Override
    public Calendar getByID(int id) throws CalendarDAOException {
        PreparedStatement statement = null;
        logger.info("Log for get Calendar by id");

        try (Connection connection = manager.getConnection()){
            statement = connection.prepareStatement("SELECT calend.*, doc.first_name, doc.family_name, " +
                    "doc.patronymic, doc.specialization, doc.office\n" +
                    "FROM public.\"calendar\" calend LEFT JOIN public.\"doctor\" doc " +
                    "ON calend.\"doctor_id\" = doc.id_doctor AND doc.family_name = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Calendar(
                    resultSet.getInt("id_calendar"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getString("monday"),
                    resultSet.getString("tuesday"),
                    resultSet.getString("wednesday"),
                    resultSet.getString("thursday"),
                    resultSet.getString("friday"),
                    resultSet.getString("saturday"),
                    resultSet.getString("sunday"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CalendarDAOException();
        }
    }

    public Calendar getByFamilyName(String familyName) throws CalendarDAOException {
        PreparedStatement statement = null;
        logger.debug("Log for get certain Doctor by ID");

        try(Connection connection = manager.getConnection()) {
            statement = connection.prepareStatement("SELECT calend.*, doc.first_name, doc.family_name, " +
                    "doc.patronymic, doc.specialization, doc.office\n" +
                    "FROM public.\"calendar\" calend JOIN public.\"doctor\" doc " +
                    "ON calend.\"doctor_id\" = doc.id_doctor AND doc.family_name = ?;");
            statement.setString(1, familyName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Calendar(
                    resultSet.getInt("id_calendar"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getString("monday"),
                    resultSet.getString("tuesday"),
                    resultSet.getString("wednesday"),
                    resultSet.getString("thursday"),
                    resultSet.getString("friday"),
                    resultSet.getString("saturday"),
                    resultSet.getString("sunday"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("specialization"),
                    resultSet.getString("office"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CalendarDAO.CalendarDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE calendar SET doctor_id = ?, monday = ?, tuesday = ?, " +
                        "wednesday = ?, thursday = ?, friday = ?, saturday = ?, sunday = ? WHERE id_calendar = ?");
    }

    @Override
    public void update(Calendar calendar) throws CalendarDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()){
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
        try (Connection connection = manager.getConnection()){
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
        try (Connection connection = manager.getConnection()){
            statement = connection.prepareStatement(
                    "DELETE calendar WHERE id_calendar = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CalendarDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "INSERT INTO calendar (id_calendar, doctor_id, monday, tuesday, wednesday, " +
                        "thursday, friday, saturday, sunday) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Calendar calendar) throws CalendarDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()){
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
        try (Connection connection = manager.getConnection()){
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
