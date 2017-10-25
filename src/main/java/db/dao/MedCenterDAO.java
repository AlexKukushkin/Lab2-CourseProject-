package db.dao;

import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import pojo.MedCenter;
import db.TomcatConnectionPool;
import db.IConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedCenterDAO implements IAbstractDAO <MedCenter>{
    public static class MedCenterDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(MedCenterDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<MedCenter> getAll() throws MedCenterDAOException {
        List<MedCenter> medCenterList = new ArrayList<>();
        logger.info("Log for getAll MedCenters");

        Statement statement = null;

        try (Connection connection = manager.getConnection()){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM medcenter");
            while (resultSet.next()) {
                MedCenter medCenter = new MedCenter(
                        resultSet.getInt("id_medcenter"),
                        resultSet.getString("medcenter_name"),
                        resultSet.getString("region_name"),
                        resultSet.getString("location_name"));
                medCenterList.add(medCenter);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
        return medCenterList;
    }

    @Override
    public MedCenter getByID(int id) throws MedCenterDAOException {
        PreparedStatement statement = null;
        logger.info("Log for get MedCenter by ID");

        try (Connection connection = manager.getConnection()){
            statement = connection.prepareStatement("SELECT * FROM medcenter WHERE id_medcenter = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new MedCenter(
                    resultSet.getInt("id_medcenter"),
                    resultSet.getString("medcenter_name"),
                    resultSet.getString("region_name"),
                    resultSet.getString("location_name"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE medcenter SET medcenter_name = ?, region_name = ?, location_name = ? WHERE id_medcenter = ? ");
    }

    @Override
    public void update(MedCenter medCenter) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try(Connection connection = manager.getConnection()) {
            statement = getUpdateStatement();
            statement.setInt(1, medCenter.getIdMedCenter());
            statement.setString(2, medCenter.getCenterName());
            statement.setString(3, medCenter.getRegionName());
            statement.setString(4, medCenter.getLocationName());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void updateAll(List<MedCenter> medCenterList) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()){
            statement = getUpdateStatement();
            for (MedCenter medCenter : medCenterList) {
                statement.setInt(1, medCenter.getIdMedCenter());
                statement.setString(2, medCenter.getCenterName());
                statement.setString(3, medCenter.getRegionName());
                statement.setString(4, medCenter.getLocationName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()) {
            statement = connection.prepareStatement(
                    "DELETE medcenter WHERE id_medcenter = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement("INSERT INTO medcenter (id_medcenter, medcenter_name, " +
                "region_name, location_name) VALUES (?, ?, ?, ?)");
    }

    @Override
    public void insertOne(MedCenter medCenter) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()) {
            statement = getInsertStatement();
            statement.setInt(1, medCenter.getIdMedCenter());
            statement.setString(2, medCenter.getCenterName());
            statement.setString(3, medCenter.getRegionName());
            statement.setString(4, medCenter.getLocationName());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void insertAll(List<MedCenter> medCenterList) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try (Connection connection = manager.getConnection()){
            statement = getInsertStatement();
            for (MedCenter medCenter : medCenterList) {
                statement.setInt(1, medCenter.getIdMedCenter());
                statement.setString(2, medCenter.getCenterName());
                statement.setString(3, medCenter.getRegionName());
                statement.setString(4, medCenter.getLocationName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new MedCenterDAOException();
        }
    }
}
