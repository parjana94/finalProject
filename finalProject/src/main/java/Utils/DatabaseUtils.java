package Utils;

import java.sql.*;

public class DatabaseUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "Parjanadze123!";
        return DriverManager.getConnection(url, user, password);
    }
}