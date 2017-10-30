package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import pojo.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IAbstractDAO <Patient>{
    public static class PatientDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(PatientDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<Patient> getAll() throws PatientDAOException {
        List<Patient> patientList = new ArrayList<>();
        logger.info("Log for getAll Patients");

        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM patient");
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getInt("id_patient"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("passport"),
                        resultSet.getString("SNILS"),
                        resultSet.getString("medpolis"),
                        resultSet.getString("registration"),
                        resultSet.getString("home_location"),
                        resultSet.getString("sextype"),
                        resultSet.getInt("user_id"));
                patientList.add(patient);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
        return patientList;
    }

    @Override
    public Patient getByID(int id) throws PatientDAOException {

        logger.info("Log for get Patient by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patient WHERE id_patient = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Patient(
                    resultSet.getInt("id_patient"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("passport"),
                    resultSet.getString("SNILS"),
                    resultSet.getString("medpolis"),
                    resultSet.getString("registration"),
                    resultSet.getString("home_location"),
                    resultSet.getString("sextype"),
                    resultSet.getInt("user_id"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }


    public int getPatientID(int id) throws PatientDAOException {

        logger.info("Log for get Patient by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT pt.id_patient FROM patient pt JOIN users usr " +
                    "ON pt.user_id = usr.id AND usr.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id_patient");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE patient SET first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, " +
                        "passport = ?, \"SNILS\" = ?, medpolis = ?, registration = ?, home_location = ?, sextype = ? " +
                        "WHERE id_patient = ?");
    }

    @Override
    public void update(Patient patient) throws PatientDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
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
            statement.setInt(11, patient.getIdPatient());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }

    @Override
    public void updateAll(List<Patient> patientList) throws PatientDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            for (Patient patient : patientList) {
                statement.setInt(1, patient.getIdPatient());
                statement.setString(2, patient.getFirstName());
                statement.setString(3, patient.getFamilyName());
                statement.setString(4, patient.getPatronymic());
                statement.setDate(5, Date.valueOf(patient.getBirthDate()));
                statement.setString(6, patient.getPassport());
                statement.setString(7, patient.getSNILS());
                statement.setString(8, patient.getMedPolis());
                statement.setString(9, patient.getRegisterLocation());
                statement.setString(10, patient.getAddress());
                statement.setString(11, patient.getSexType());
                statement.setInt(12, patient.getIdUser());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws PatientDAOException {

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE patient WHERE id_patient = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "INSERT INTO patient(first_name, family_name, patronymic, birth_date," +
                        " passport, \"SNILS\", medpolis, registration, home_location, sextype, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Patient patient) throws PatientDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
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
            statement.setInt(11, patient.getIdUser());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }

    }

    @Override
    public void insertAll(List<Patient> patientList) throws PatientDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
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
                statement.setInt(11, patient.getIdUser());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new PatientDAOException();
        }
    }
}
