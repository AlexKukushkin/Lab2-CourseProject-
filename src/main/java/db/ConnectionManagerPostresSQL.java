package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerPostresSQL implements IConnectionManager {

    private static final ConnectionManagerPostresSQL INSTANCE = new ConnectionManagerPostresSQL();
    private Connection connection;

    private ConnectionManagerPostresSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            connection =
                    DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5433/medcenter",
                            "postgres",
                            "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionManagerPostresSQL getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
