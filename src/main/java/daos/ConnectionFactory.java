package daos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/car";
    public static final String USER = "jia";
    public static final String PASS = "jia123";


    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
