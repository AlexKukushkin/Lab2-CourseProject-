package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import dto.DoctorDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import pojo.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorDAO implements IAbstractDAO <Doctor> {
    public static class DoctorDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(DoctorDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }


    @Override
    public List<Doctor> getAll() throws DoctorDAOException {
        List<Doctor> doctorList = new ArrayList<>();
        logger.info("Log for getAll Doctors");

        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT dc.*, c.*" + //todo remove calendar
                    "FROM doctor dc LEFT JOIN calendar c ON dc.id_doctor = c.doctor_id;");
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("id_doctor"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("specialization"),
                        resultSet.getString("office"),
                        resultSet.getInt("medcenter_id"));
                doctorList.add(doctor);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
        return doctorList;
    }

    @Override
    public Doctor getByID(int id) throws DoctorDAOException {
        logger.debug("Log for get certain Doctor by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctor WHERE id_doctor = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Doctor(
                    resultSet.getInt("id_doctor"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("specialization"),
                    resultSet.getString("office"),
                    resultSet.getInt("medcenter_id"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE doctor" +
                        "SET  first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, specialization = ?, office = ?, medcenter_id = ? " +
                        "WHERE id_doctor = ? ");
    }

    @Override
    public void update(Doctor doctor) throws DoctorDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getFamilyName());
            statement.setString(3, doctor.getPatronymic());
            statement.setDate(4, Date.valueOf(doctor.getBirthDate()));
            statement.setString(5, doctor.getSpecialization());
            statement.setString(6, doctor.getOffice());
            statement.setInt(7, doctor.getMedCenterID());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
    }

    @Override
    public void updateAll(List<Doctor> doctorList) throws DoctorDAOException {
        try {
            PreparedStatement statement = getUpdateStatement();
            for (Doctor doctor : doctorList) {
                statement = getUpdateStatement();
                statement.setString(1, doctor.getFirstName());
                statement.setString(2, doctor.getFamilyName());
                statement.setString(3, doctor.getPatronymic());
                statement.setDate(4, Date.valueOf(doctor.getBirthDate()));
                statement.setString(5, doctor.getSpecialization());
                statement.setString(6, doctor.getOffice());
                statement.setInt(7, doctor.getMedCenterID());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws DoctorDAOException {

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE doctor WHERE id_doctor = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "INSERT INTO doctor (id_doctor, first_name, family_name, patronymic, birth_date, specialization," +
                        "office, medcenter_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Doctor doctor) throws DoctorDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getFamilyName());
            statement.setString(3, doctor.getPatronymic());
            statement.setDate(4, Date.valueOf(doctor.getBirthDate()));
            statement.setString(5, doctor.getSpecialization());
            statement.setString(6, doctor.getOffice());
            statement.setInt(7, doctor.getMedCenterID());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }

    }

    @Override
    public void insertAll(List<Doctor> doctorList) throws DoctorDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
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
                statement.setString(10, doctor.getRole());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
    }

    public List<String> getDoctorSpecialization(int idMedCenter) throws DoctorDAOException {
        List<String> specializationList = new ArrayList<>();
        String specialization;

        PreparedStatement statement = null;
        logger.debug("Log for get certain specialization");

        try (Connection connection = manager.getConnection()) {
            statement = connection.prepareStatement("SELECT DISTINCT(specialization) FROM doctor dc JOIN medcenter md " +
                    "ON dc.medcenter_id = md.id_medcenter AND md.id_medcenter = ?");
            statement.setInt(1, idMedCenter);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                specialization = resultSet.getString("specialization");
                specializationList.add(specialization);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
        return specializationList;
    }

    public List<DoctorDTO> getDoctor(int idMedCenter, String specialization) throws DoctorDAOException {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        logger.debug("Log for get certain Doctor by specialization and medcenter");

        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT dc.id_doctor, dc.first_name, dc.family_name, dc.patronymic, " +
                    "dc.specialization, dc.office, md.medcenter_name FROM doctor dc\n" +
                    "JOIN medcenter md ON dc.medcenter_id = md.id_medcenter AND dc.specialization = ? " +
                    "AND md.id_medcenter = ? ");
            statement.setString(1, specialization);
            statement.setInt(2, idMedCenter);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DoctorDTO doctorDTO = new DoctorDTO(
                        resultSet.getInt("id_doctor"),
                        resultSet.getString("first_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("family_name"),
                        resultSet.getString("specialization"),
                        resultSet.getString("office"),
                        resultSet.getString("medcenter_name"));
                doctorDTOList.add(doctorDTO);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAOException();
        }
        return doctorDTOList;
    }

    public int getDoctorID(int id, String specialization) throws DoctorDAO.DoctorDAOException {
        logger.info("Log for get Doctor by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT dc.id_doctor FROM doctor dc JOIN medcenter md " +
                    "ON dc.medcenter_id = md.id_medcenter AND md.id_medcenter = ? and dc.specialization = ?");
            statement.setInt(1, id);
            statement.setString(2, specialization);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id_doctor");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new DoctorDAO.DoctorDAOException();
        }
    }
}
