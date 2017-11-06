package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import dto.TicketDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import pojo.Ticket;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAO implements IAbstractDAO <Ticket> {
    public static class TicketDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(TicketDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<Ticket> getAll() throws TicketDAOException {
        List<Ticket> ticketList = new ArrayList<>();
        logger.info("Log for getAll Tickets");

        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT tk.id_ticket, pt.first_name, pt.family_name, pt.patronymic, \n" +
                    "concat(dc.family_name,' ',left(dc.first_name, 1),'. ',left(dc.patronymic, 1),'.') as DoctorFIO, dc.office, dc.specialization,\n" +
                    "tk.time_patient, tk.date_patient, md.medcenter_name \n" +
                    "FROM ticket tk LEFT JOIN patient pt ON pt.id_patient = tk.patient_id LEFT JOIN doctor dc ON dc.id_doctor = tk.doctor_id\n" +
                    "LEFT JOIN medcenter md ON md.id_medcenter = tk.medcenter_id;");

            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id_ticket"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("DoctorFIO"),
                        resultSet.getString("office"),
                        resultSet.getString("specialization"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"),
                        resultSet.getString("medcenter_name"));
                ticketList.add(ticket);
            }
            System.out.println(ticketList);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
        return ticketList;
    }

    public List<TicketDTO> getRegisteredTickes(int idDoctor, int idMedCenter, String specialization, String date) throws TicketDAOException {
        List<TicketDTO> ticketList = new ArrayList<>();
        logger.info("Log for getAll Registered Tickets");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT tk.id_ticket, pt.first_name, pt.family_name, pt.patronymic, \n" +
                    "concat(dc.family_name,' ',left(dc.first_name, 1),'. ',left(dc.patronymic, 1),'.') as DoctorFIO, dc.office, dc.specialization, \n" +
                    "tk.time_patient, tk.date_patient, md.medcenter_name \n" +
                    "FROM ticket tk LEFT JOIN patient pt ON pt.id_patient = tk.patient_id LEFT JOIN doctor dc ON dc.id_doctor = tk.doctor_id  \n" +
                    "LEFT JOIN medcenter md ON md.id_medcenter = tk.medcenter_id \n" +
                    "WHERE dc.id_doctor = ? AND md.id_medcenter = ? \n" +
                    "AND dc.specialization = ? \n" +
                    "AND tk.date_patient::date = ?;");

            statement.setInt(1, idDoctor);
            statement.setInt(2, idMedCenter);
            statement.setString(3, specialization);
            statement.setDate(4, Date.valueOf(date));

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TicketDTO ticket = new TicketDTO(
                        resultSet.getInt("id_ticket"),
                        resultSet.getString("DoctorFIO"),
                        resultSet.getString("office"),
                        resultSet.getString("specialization"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"));
                ticketList.add(ticket);
            }
            System.out.println(ticketList);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
        return ticketList;
    }


    @Override
    public Ticket getByID(int id) throws TicketDAOException {

        logger.info("Log for get Ticket by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket WHERE id_ticket = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Ticket(
                        resultSet.getInt("id_ticket"),
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("medcenter_id"),
                        resultSet.getString("date_patient"),
                        resultSet.getString("time_patient"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    public List<Ticket> getTicketsById(int id) throws TicketDAOException {
        List<Ticket> ticketList = new ArrayList<>();
        logger.info("Log for getAll Tickets");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT tk.id_ticket, pt.first_name, pt.family_name, pt.patronymic, \n" +
                    "concat(dc.family_name,' ',left(dc.first_name, 1),'. ',left(dc.patronymic, 1),'.') as DoctorFIO, dc.office, dc.specialization,\n" +
                    "tk.time_patient, tk.date_patient, md.medcenter_name \n" +
                    "FROM ticket tk JOIN patient pt ON pt.id_patient = tk.patient_id AND pt.id_patient = ? JOIN doctor dc ON dc.id_doctor = tk.doctor_id\n" +
                    "JOIN medcenter md ON md.id_medcenter = tk.medcenter_id;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id_ticket"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("DoctorFIO"),
                        resultSet.getString("office"),
                        resultSet.getString("specialization"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"),
                        resultSet.getString("medcenter_name"));
                ticketList.add(ticket);
            }
            System.out.println(ticketList);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
        return ticketList;
    }

    public Ticket getTicket(int id, int idDoctor, int idMedCenter, String time, String date) throws TicketDAOException, ParseException {
        logger.info("Log for getAll Tickets");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT tk.id_ticket, pt.first_name, pt.family_name, pt.patronymic, \n" +
                    "concat(dc.family_name,' ',left(dc.first_name, 1),'. ',left(dc.patronymic, 1),'.') as DoctorFIO, dc.office, dc.specialization,\n" +
                    "tk.time_patient, tk.date_patient, md.medcenter_name \n" +
                    "FROM ticket tk JOIN patient pt ON pt.id_patient = tk.patient_id JOIN doctor dc ON dc.id_doctor = tk.doctor_id\n" +
                    "JOIN medcenter md ON md.id_medcenter = tk.medcenter_id " +
                    "WHERE pt.id_patient = ? " +
                    "AND dc.id_doctor = ? " +
                    "AND md.id_medcenter = ? " +
                    "AND tk.time_patient = ? " +
                    "AND tk.date_patient::date = ?;");
            statement.setInt(1, id);
            statement.setInt(2, idDoctor);
            statement.setInt(3, idMedCenter);
            statement.setString(4, time);
            statement.setDate(5, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()));

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
                return new Ticket(
                        resultSet.getInt("id_ticket"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("DoctorFIO"),
                        resultSet.getString("office"),
                        resultSet.getString("specialization"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"),
                        resultSet.getString("medcenter_name"));

        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE ticket SET patient_id = ?, doctor_id = ?, medcenter_id = ?, " +
                        "time_patient = ?, date_patient = ? WHERE id_ticket = ? ");
    }

    @Override
    public void update(Ticket ticket) throws TicketDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            statement.setInt(1, ticket.getIdTicket());
            statement.setString(2, ticket.getPatientTime());
            statement.setString(3, ticket.getPatientDate());
            statement.setInt(5, ticket.getIdPatient());
            statement.setInt(6, ticket.getIdDoctor());
            statement.setInt(7, ticket.getIdMedCenter());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    @Override
    public void updateAll(List<Ticket> ticketList) throws TicketDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdTicket());
                statement.setString(2, ticket.getPatientTime());
                statement.setString(3, ticket.getPatientDate());
                statement.setInt(5, ticket.getIdPatient());
                statement.setInt(6, ticket.getIdDoctor());
                statement.setInt(7, ticket.getIdMedCenter());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws TicketDAOException {
        PreparedStatement statement;
        try (Connection connection = manager.getConnection()) {
            statement = connection.prepareStatement(
                    "DELETE ticket WHERE id_ticket = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.
                prepareStatement("INSERT INTO ticket (time_patient, date_patient, patient_id, doctor_id, medcenter_id)" +
                " VALUES (?, ?, ?, ?, ?) ");
    }

    @Override
    public void insertOne(Ticket ticket) throws TicketDAOException, ParseException {
        try {
            PreparedStatement statement = getInsertStatement();
            statement.setString(1, ticket.getPatientTime());
            statement.setDate(2, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(ticket.getPatientDate()).getTime()));
            statement.setInt(3, ticket.getIdPatient());
            statement.setInt(4, ticket.getIdDoctor());
            statement.setInt(5, ticket.getIdMedCenter());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    @Override
    public void insertAll(List<Ticket> ticketList) throws TicketDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdTicket());
                statement.setString(2, ticket.getPatientTime());
                statement.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(ticket.getPatientDate()).getTime()));
                statement.setInt(5, ticket.getIdPatient());
                statement.setInt(6, ticket.getIdDoctor());
                statement.setInt(7, ticket.getIdMedCenter());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        } catch (ParseException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
