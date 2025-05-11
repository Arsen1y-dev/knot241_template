package lab11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    private static final String URL = "jdbc:sqlite:/Users/arseniy/Documents/GitHub/knot241_template/lab11/pupa";
    private static Connection connection;

    private DbConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
}


// jdbc:sqlite:/Users/arseniy/Documents/GitHub/knot241_template/lab11/pupa