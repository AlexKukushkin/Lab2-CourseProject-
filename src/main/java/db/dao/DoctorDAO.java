package db.dao;

import classes.Doctor;
import db.IConnectionManager;
import db.ConnectionManagerPostresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements IAbstractDAO <Doctor> {
    public static class DoctorDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostresSQL.getInstance();
    }

    /**
     * Метод возвращает список врачей из БД
     * @return List<Doctor> список врачей
     * @throws DoctorDAOException
     */
    @Override
    public List<Doctor> getAll() throws DoctorDAOException {
        List<Doctor> doctorList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT dc.*, c.*" +
                    "FROM doctor dc LEFT JOIN calendar c ON dc.id = c.doctor_id;");
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("specialization"),
                        resultSet.getString("office"));
                doctorList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
        return doctorList;
    }

    @Override
    public Doctor getByID(int id) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM doctor WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Doctor(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("specialization"),
                    resultSet.getString("office"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE doctor" +
                        "SET  first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, specialization = ?, office = ?, " +
                        "login = ?, password = ? WHERE id = ? ");
    }

    @Override
    public void update(Doctor doctor) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getFamilyName());
            statement.setString(3, doctor.getPatronymic());
            statement.setDate(4, Date.valueOf(doctor.getBirthDate()));
            statement.setString(5, doctor.getSpecialization());
            statement.setString(6, doctor.getOffice());
            statement.setString(7, doctor.getLogin());
            statement.setString(8, doctor.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
    }

    @Override
    public void updateAll(List<Doctor> doctorList) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Doctor doctor : doctorList) {
                statement.setString(1, doctor.getFirstName());
                statement.setString(2, doctor.getFamilyName());
                statement.setString(3, doctor.getPatronymic());
                statement.setDate(4, Date.valueOf(doctor.getBirthDate()));
                statement.setString(5, doctor.getSpecialization());
                statement.setString(6, doctor.getOffice());
                statement.setString(7, doctor.getLogin());
                statement.setString(8, doctor.getPassword());
                statement.addBatch();

            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE doctor WHERE id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "INSERT INTO doctor (id, first_name, family_name, patronymic, birth_date, specialization," +
                        "office, login, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Doctor doctor) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, doctor.getIdDoctor());
            statement.setString(2, doctor.getFirstName());
            statement.setString(3, doctor.getFamilyName());
            statement.setString(4, doctor.getPatronymic());
            statement.setDate(5, Date.valueOf(doctor.getBirthDate()));
            statement.setString(6, doctor.getSpecialization());
            statement.setString(7, doctor.getOffice());
            statement.setString(8, doctor.getLogin());
            statement.setString(9, doctor.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }

    }

    @Override
    public void insertAll(List<Doctor> doctorList) throws DoctorDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Doctor doctor : doctorList) {
                statement.setInt(1, doctor.getIdDoctor());
                statement.setString(2, doctor.getFirstName());
                statement.setString(3, doctor.getFamilyName());
                statement.setString(4, doctor.getPatronymic());
                statement.setDate(5, Date.valueOf(doctor.getBirthDate()));
                statement.setString(6, doctor.getSpecialization());
                statement.setString(7, doctor.getOffice());
                statement.setString(8, doctor.getLogin());
                statement.setString(9, doctor.getPassword());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DoctorDAOException();
        }
    }
}
