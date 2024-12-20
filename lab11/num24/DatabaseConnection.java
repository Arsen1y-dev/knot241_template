package lab11.num24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:/Users/arseniy/Documents/GitHub/knot241_template/lab11/num24/:Users:arseniy:Documents:GitHub:knot241_template:lab11:Untitled";
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
}