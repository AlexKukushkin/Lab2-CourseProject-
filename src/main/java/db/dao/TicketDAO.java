package db.dao;

import classes.Ticket;
import db.ConnectionManagerPostresSQL;
import db.IConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements IAbstractDAO <Ticket> {
    public static class TicketDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostresSQL.getInstance();
    }

    @Override
    public List<Ticket> getAll() throws TicketDAOException {
        List<Ticket> ticketList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ticket");
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("medcenter_id"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"),
                        resultSet.getString("day_patient"));
                ticketList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
        return ticketList;
    }

    @Override
    public Ticket getByID(int id) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM ticket WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Ticket(
                    resultSet.getInt("patient_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getInt("medcenter_id"),
                    resultSet.getString("time_patient"),
                    resultSet.getString("date_patient"),
                    resultSet.getString("day_patient"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE ticket SET patient_id = ?, doctor_id = ?, medcenter_id = ?, " +
                        "time_patient = ?, date_patient = ?, day_patient = ? WHERE id = ? ");
    }

    @Override
    public void update(Ticket ticket) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setInt(1, ticket.getIdPatient());
            statement.setInt(2, ticket.getIdDoctor());
            statement.setInt(3, ticket.getIdMedCenter());
            statement.setString(4, ticket.getPatientTime());
            statement.setString(5, ticket.getPatientDate());
            statement.setString(6, ticket.getPatientDay());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }

    @Override
    public void updateAll(List<Ticket> ticketList) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdPatient());
                statement.setInt(2, ticket.getIdDoctor());
                statement.setInt(3, ticket.getIdMedCenter());
                statement.setString(4, ticket.getPatientTime());
                statement.setString(5, ticket.getPatientDate());
                statement.setString(6, ticket.getPatientDay());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE ticket WHERE id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement("INSERT INTO ticket VALUE " +
                "(patient_id = ?, doctor_id = ?, medcenter_id = ?, time_patient = ?, date_patient = ?, " +
                "day_patient = ?)");
    }

    @Override
    public void insertOne(Ticket ticket) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, ticket.getIdPatient());
            statement.setInt(2, ticket.getIdDoctor());
            statement.setInt(3, ticket.getIdMedCenter());
            statement.setString(4, ticket.getPatientTime());
            statement.setString(5, ticket.getPatientDate());
            statement.setString(6, ticket.getPatientDay());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }

    @Override
    public void insertAll(List<Ticket> ticketList) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdPatient());
                statement.setInt(2, ticket.getIdDoctor());
                statement.setInt(3, ticket.getIdMedCenter());
                statement.setString(4, ticket.getPatientTime());
                statement.setString(5, ticket.getPatientDate());
                statement.setString(6, ticket.getPatientDay());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TicketDAOException();
        }
    }
}
