import java.sql.*;
import java.util.HashMap;
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
        String query = "insert into users (email, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        return rowAffected;
    }
    @Override
    public void userLogin(User user) throws SQLException {
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println("Please wait...");
        String sql = "SELECT * FROM users WHERE email = " + "'" + email + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(!rs.isBeforeFirst()) {
            user.setUserId(0);
        }else{
            rs.next();
            int o = rs.getInt("userId");
            String pass = rs.getString("password");
            if (pass.equalsIgnoreCase(password)) {
                System.out.println("Logged in");
                user.setUserId(o);
                user.setEmail(email);
                user.setLoggedIn(true);
            } else {
                System.out.println(ColorTheme.RED_BRIGHT + "Invalid Log In Information" + ColorTheme.RESET);
            }
        }
    }

    @Override
    public void deposit(double amt, int accountId) throws SQLException {
        String query = "UPDATE accounts SET balance = balance + ? WHERE accountId = ?";
        PreparedStatement preparedStatement =  connection.prepareStatement(query);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, accountId);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        if(rowAffected < 1) {
            throw new SQLException("Deposit failed");
        }else{
            System.out.println("Deposit successful");
        }
    }

    @Override
    public void withdraw(double amt, int accountId) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE accountId = " + "'" + accountId + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        double currentBalance = rs.getDouble("balance");
        if(currentBalance - amt < 0) {
            System.out.println(ColorTheme.RED_BRIGHT + "Insufficient Funds" + ColorTheme.RESET);
        }else{
            String query = "UPDATE accounts SET balance = balance - ? WHERE accountId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amt);
            preparedStatement.setInt(2, accountId);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("(" + rowAffected + ") rows affected");
            if (rowAffected < 1) {
                throw new SQLException("Withdraw failed");
            } else {
                System.out.println("Withdraw successful");
            }
        }
    }

    @Override
    public void transferMoney(User user, double amt, int to, int from) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE accountId = " + "'" + from + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        double fromBalance = rs.getDouble("balance");
        if (fromBalance - amt < 0) {
            System.out.println(ColorTheme.RED_BRIGHT + "Insufficient Funds" + ColorTheme.RESET);
        } else {
            String query = "insert into pending_transfers (userId, amount, transfer_to_account, transfer_from_account) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setDouble(2, amt);
            preparedStatement.setInt(3, to);
            preparedStatement.setInt(4, from);
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 1) {
                throw new SQLException("Error transfer not complete");
            }
            System.out.println(ColorTheme.GREEN_BOLD_BRIGHT + "Transfer Successful" + ColorTheme.RESET);
        }
    }

    @Override
    public void createAccount(User user, double amt) throws SQLException {
        String query = "insert into pending_accounts (userId, accountDeposit) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user.getUserId());
        preparedStatement.setDouble(2, amt);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        if(rowAffected < 1) {
            System.out.println("Error creating account");
        }else{
            System.out.println("Account Pending approval");

        }
    }
    @Override
    public void viewAccount(int accountId) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE accountId = " + "'" + accountId + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        double balance = rs.getDouble("balance");
        System.out.println("Account Number: " + accountId);
        System.out.println("Balance $" + balance);
    }
    @Override
    public void getAccounts(User user) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE userId = " + "'" + user.getUserId() + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
        System.out.println("\nAccount " + rs.getInt("accountId"));
        System.out.println("Balance " + ColorTheme.GREEN_BRIGHT + "$" + (rs.getString("balance")) + ColorTheme.RESET);
        }
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
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User userById(int id) {
        return null;
    }
}
