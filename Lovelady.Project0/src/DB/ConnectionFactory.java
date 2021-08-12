package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection = null;

    static Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/revature";
            String username = "root";
            String password = "abc";
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}
