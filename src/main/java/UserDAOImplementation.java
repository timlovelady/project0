import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class UserDAOImplementation implements UserDAO {
    private static Statement statement = null;
    Connection connection = null;

    public UserDAOImplementation()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public int registerUser(User user) throws SQLException {
        String query = "insert into users (username, email, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        connection.close();
        return rowAffected;
    }

    @Override
    public int userLogin(User user) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("Got data logging in...");
        String sql = "SELECT * FROM users WHERE username = " + "'" + username + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int o = rs.getInt("userId");
        String pass = rs.getString("password");
        if(pass .equalsIgnoreCase(password)) {
            user.setUserId(o);
            user.setUsername(username);
            user.setLoggedIn(true);
            return 1;
        }
        return 0;
    }


    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "update users set username = ?, email = ? where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getUserId());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("User updated");
        else
            System.out.println("Error updating user");
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "delete from users where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("User Removed");
        else
            System.out.println("Error removing user");
    }

    @Override
    public List<User> getUser() {
        List<User> user = getUser();
        return  user;
    }

    @Override
    public User userById(int id) {
        return null;
    }
}
