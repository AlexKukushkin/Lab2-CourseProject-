package db.dao;

import pojo.MedCenter;
import db.ConnectionManagerPostgreSQL;
import db.IConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedCenterDAO implements IAbstractDAO <MedCenter>{
    public static class MedCenterDAOException extends Exception {

    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

    @Override
    public List<MedCenter> getAll() throws MedCenterDAOException {
        List<MedCenter> medCenterList = new ArrayList<>();
        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
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
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
        return medCenterList;
    }

    @Override
    public MedCenter getByID(int id) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM medcenter WHERE id_medcenter = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new MedCenter(
                    resultSet.getInt("id_medcenter"),
                    resultSet.getString("medcenter_name"),
                    resultSet.getString("region_name"),
                    resultSet.getString("location_name"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE medcenter SET medcenter_name = ?, region_name = ?, location_name = ? WHERE id_medcenter = ? ");
    }

    @Override
    public void update(MedCenter medCenter) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setInt(1, medCenter.getIdMedCenter());
            statement.setString(2, medCenter.getMedCenterName());
            statement.setString(3, medCenter.getRegionName());
            statement.setString(4, medCenter.getLocationName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void updateAll(List<MedCenter> medCenterList) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (MedCenter medCenter : medCenterList) {
                statement.setInt(1, medCenter.getIdMedCenter());
                statement.setString(2, medCenter.getMedCenterName());
                statement.setString(3, medCenter.getRegionName());
                statement.setString(4, medCenter.getLocationName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE medcenter WHERE id_medcenter = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement("INSERT INTO medcenter (id_medcenter, medcenter_name, " +
                "region_name, location_name) VALUES (?, ?, ?, ?)");
    }

    @Override
    public void insertOne(MedCenter medCenter) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, medCenter.getIdMedCenter());
            statement.setString(2, medCenter.getMedCenterName());
            statement.setString(3, medCenter.getRegionName());
            statement.setString(4, medCenter.getLocationName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }

    @Override
    public void insertAll(List<MedCenter> medCenterList) throws MedCenterDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (MedCenter medCenter : medCenterList) {
                statement.setInt(1, medCenter.getIdMedCenter());
                statement.setString(2, medCenter.getMedCenterName());
                statement.setString(3, medCenter.getRegionName());
                statement.setString(4, medCenter.getLocationName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MedCenterDAOException();
        }
    }
}
