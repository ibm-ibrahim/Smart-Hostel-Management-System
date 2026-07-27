package user.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/HostelBookingSystem";
    private String username = "root";   // use your MySQL username
    private String password = "root";   // use your MySQL password

    private DBConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Database connection failed");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws Exception {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
}
