package P2;

import java.sql.*;

public class DB {

   private String url = "jdbc:mysql://localhost:3306/revature";
    private String username = "root";
    private String password = "abc";
    Connection connection;

    public void login(String email) {

        {
            try {
                connection = DriverManager.getConnection(url, username, password);
                String sql = "SELECT * FROM users WHERE email = " + email;
               PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("id: " + id);
                    String name = resultSet.getString(2);
                    String e = resultSet.getString(3);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
