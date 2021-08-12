package DB;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao implements Dao<User>{


    private static Statement statement = null;
    Connection connection = null;

    public UserDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int userId = resultSet.getInt(1);
            System.out.println("User Id: " + userId);
            String username = resultSet.getString(2);
            System.out.println("Username: " + username);
            String email = resultSet.getString(3);
            User user = new User(userId, username, email);
            users.add(user);
        }
        return users;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void login(User user, String[] params) throws SQLException {

    }


    public void login() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from users where email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        String email = sc.next();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int userId = resultSet.getInt(1);
            System.out.println("User Id: " + userId);
            String username = resultSet.getString(2);
            System.out.println("Username: " + username);
        }
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
