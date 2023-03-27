package DbConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection con = null;

    private DatabaseConnection() throws SQLException, IOException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservations", "root", "");
//            System.out.println("Database Connection Established");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DatabaseConnection getInstance() throws SQLException, IOException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return con;
    }
}
