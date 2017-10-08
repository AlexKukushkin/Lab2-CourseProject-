package db.dao;

import classes.Patient;
import db.ConnectionManagerPostresSQL;
import db.IConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IAbstractDAO <Patient>{
    public static class PatientDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostresSQL.getInstance();
    }

    @Override
    public List<Patient> getAll() throws PatientDAOException {
        List<Patient> patientList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT pt.*, tk.*" +
//                    "FROM patient pt LEFT JOIN ticket tk ON pt.id = tk.patient_id");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patient");
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("passport"),
                        resultSet.getString("SNILS"),
                        resultSet.getString("medpolis"),
                        resultSet.getString("registration"),
                        resultSet.getString("home_location"),
                        resultSet.getString("sextype"));
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
        return patientList;
    }

    @Override
    public Patient getByID(int id) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM patient WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Patient(
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("passport"),
                    resultSet.getString("SNILS"),
                    resultSet.getString("medpolis"),
                    resultSet.getString("registration"),
                    resultSet.getString("home_location"),
                    resultSet.getString("sextype"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE patient" +
                        "SET  first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, " +
                        "passport = ?, SNILS = ?, medpolis = ?, registration = ?, home_location = ?, sextype = ?" +
                        "login = ?, password = ? WHERE id = ? ");
    }

    @Override
    public void update(Patient patient) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getFamilyName());
            statement.setString(3, patient.getPatronymic());
            statement.setDate(4, Date.valueOf(patient.getBirthDate()));
            statement.setString(5, patient.getPassport());
            statement.setString(6, patient.getSNILS());
            statement.setString(7, patient.getMedPolis());
            statement.setString(8, patient.getRegisterLocation());
            statement.setString(9, patient.getAddress());
            statement.setString(10, patient.getSexType());
            statement.setString(11, patient.getLogin());
            statement.setString(12, patient.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
    }

    @Override
    public void updateAll(List<Patient> patientList) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Patient patient : patientList) {
                statement.setString(1, patient.getFirstName());
                statement.setString(2, patient.getFamilyName());
                statement.setString(3, patient.getPatronymic());
                statement.setDate(4, Date.valueOf(patient.getBirthDate()));
                statement.setString(5, patient.getPassport());
                statement.setString(6, patient.getSNILS());
                statement.setString(7, patient.getMedPolis());
                statement.setString(8, patient.getRegisterLocation());
                statement.setString(9, patient.getAddress());
                statement.setString(10, patient.getSexType());
                statement.setString(11, patient.getLogin());
                statement.setString(12, patient.getPassword());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE patient WHERE id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "INSERT INTO patient " +
                        "VALUE  (first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, " +
                        "passport = ?, SNILS = ?, medpolis = ?, registration = ?, home_location = ?, sextype = ?," +
                        "login = ?, password = ?)");
    }

    @Override
    public void insertOne(Patient patient) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getFamilyName());
            statement.setString(3, patient.getPatronymic());
            statement.setDate(4, Date.valueOf(patient.getBirthDate()));
            statement.setString(5, patient.getPassport());
            statement.setString(6, patient.getSNILS());
            statement.setString(7, patient.getMedPolis());
            statement.setString(8, patient.getRegisterLocation());
            statement.setString(9, patient.getAddress());
            statement.setString(10, patient.getSexType());
            statement.setString(11, patient.getLogin());
            statement.setString(12, patient.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }

    }

    @Override
    public void insertAll(List<Patient> patientList) throws PatientDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Patient patient : patientList) {
                statement.setString(1, patient.getFirstName());
                statement.setString(2, patient.getFamilyName());
                statement.setString(3, patient.getPatronymic());
                statement.setDate(4, Date.valueOf(patient.getBirthDate()));
                statement.setString(5, patient.getPassport());
                statement.setString(6, patient.getSNILS());
                statement.setString(7, patient.getMedPolis());
                statement.setString(8, patient.getRegisterLocation());
                statement.setString(9, patient.getAddress());
                statement.setString(10, patient.getSexType());
                statement.setString(11, patient.getLogin());
                statement.setString(12, patient.getPassword());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PatientDAOException();
        }
    }
}
