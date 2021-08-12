import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImplementation implements EmployeeDAO {
    private static Statement statement = null;
    Connection connection = null;

    public EmployeeDAOImplementation() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int registerEmployee(Employee employee) throws SQLException {
        String query = "insert into employees (email, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getEmail());
        preparedStatement.setString(2, employee.getPassword());
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("(" + rowAffected + ") rows affected");
        return rowAffected;
    }

    @Override
    public void getPendingAccounts() throws SQLException {
        String sql = "SELECT * FROM pending_accounts";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println("\nTransaction Id " + rs.getInt("transactionId"));
            System.out.println("User Id " + rs.getInt("userId"));
            System.out.println("Deposit Amount $" + " " + rs.getInt("accountDeposit") + "\n");
        }
    }

    @Override
    public void employeeLogin(Employee employee) throws SQLException {
        String email = employee.getEmail();
        String password = employee.getPassword();
        System.out.println("Got data logging in...");
        String sql = "SELECT * FROM employees WHERE email = " + "'" + email + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
            rs.next();
            int o = rs.getInt("employeeId");
            String pass = rs.getString("password");
            if (pass.equalsIgnoreCase(password)) {
                System.out.println("Logged in");
                employee.setEmployeeId(o);
                employee.setEmail(email);
                employee.setLoggedIn(true);
            }

    }

    @Override
    public void approveAccount(int transactionId) throws SQLException {
        String sql = "SELECT * FROM pending_accounts WHERE transactionId = " + "'" + transactionId + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("userId");
        double amt = rs.getDouble("accountDeposit");
        String query = "insert into accounts (userId, balance) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setDouble(2, amt);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("(" + rowAffected + ") rows affected");
        System.out.println("Account approved");
        if(rowAffected > 0) {
            System.out.println("Dropping pending transaction");
            String query2 = "DELETE FROM pending_accounts WHERE transactionId  = ?";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, transactionId);
            int rem = preparedStatement.executeUpdate();
            if(rem > 1) {
                System.out.println("Done");
            }else{
                System.out.println("Error removing account from pending status");
            }
        }
    }
    @Override
    public void denyAccount(int transactionId) throws SQLException {
            System.out.println("Deny pending transaction");
            String query2 = "DELETE FROM pending_accounts WHERE transactionId  = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, transactionId);
            int rem = preparedStatement.executeUpdate();
            if(rem <= 1) {
                System.out.println("Done");
            }else{
                System.out.println("Error removing account from pending status");
            }

    }
    @Override
    public void viewAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(ColorTheme.BLUE_BRIGHT + "\nAccount ID: " + ColorTheme.RESET+ rs.getInt("accountId"));
            System.out.println(ColorTheme.BLUE_BRIGHT + "User ID: " + ColorTheme.RESET + rs.getInt("userId"));
            System.out.println(ColorTheme.BLUE_BRIGHT + "Balance " + ColorTheme.GREEN_BRIGHT + "$" + rs.getDouble("balance") + ColorTheme.RESET);
        }
    }
    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employees where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Employee Removed");
        else
            System.out.println("Error removing employee");
    }

    @Override
    public List<Employee> getEmployee() {
        return null;
    }

    @Override
    public Employee employeeById(int id) {
        return null;
    }
}


