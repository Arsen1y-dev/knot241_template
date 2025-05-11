package lab11;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Task24();
    }
    private static void Task25() {
        try (Connection conn = DbConnection.getConnection()) {
            FileDAO fileDAO = new FileDAOImpl(conn);
            FileApp fileApp = new FileApp(fileDAO);
            fileApp.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Task24() {
        try (Connection conn = DbConnection.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(conn);
            UserService userService = new UserServiceImpl(userDAO);
            UserManager userManager = new UserManager(userService);
            userManager.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

