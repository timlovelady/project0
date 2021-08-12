import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class Queries {
    public void getUserByEmail(String email) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        String sql = "SELECT * FROM users WHERE email = " + "'" + email + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }
    }
public void getAccounts(int id) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
    String sql = "SELECT * FROM accounts WHERE userId = " + "'" + id + "'";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    System.out.println("    Accounts");
    while (rs.next()) {
        System.out.println("Account Number" + rs.getInt("accountId"));
        System.out.println("\nAccount Balance" + rs.getDouble("balance"));
    }
}
    public int login() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        System.out.print("  Enter email ==> ");
        String email = sc.next();
        System.out.print("  Enter password ==> ");
        String password = sc.next();
        String sql = "SELECT * FROM users WHERE email = " + "'" + email + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int o = rs.getInt("userId");
        String pass = rs.getString("password");
        if(pass .equalsIgnoreCase(password)) {
            System.out.println("O: " + o + pass);
            return 1;
        }else{
            return 0;
        }
    }

    public int employeeLogin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        System.out.print("  Enter email ==> ");
        String email = sc.next();
        System.out.print("  Enter password ==> ");
        String password = sc.next();
        String sql = "SELECT * FROM employees WHERE email = " + "'" + email + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int o = rs.getInt("userId");
        String pass = rs.getString("password");
        if(pass .equalsIgnoreCase(password)) {
            System.out.println("O: " + o + pass);
            return 1;
        }else{
            return 0;
        }
    }
    public int register() throws SQLException {
        String ema;
        String pass;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter email ==> ");
        ema = sc.next();
        System.out.print("  Enter password ==> ");
        pass = sc.next();
        String query = "insert into users (email, password) values (?, ?)";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setString(1, ema);
        preparedStatement.setString(2, pass);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        conn.close();
        return rowAffected;
    }
    public int employeeRegister() throws SQLException {
        String email;
        String password;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter email ==> ");
        email = sc.next();
        System.out.print("  Enter password ==> ");
        password = sc.next();
        String query = "INSERT INTO employees (email, password) values (?, ?)";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        conn.close();
        return rowAffected;
    }
    public void createAccount() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter Account ID ==> ");
        int id = sc.nextInt();
        System.out.print("  Enter Deposit Amount ==> ");
        double amt = sc.nextDouble();
        String query = "insert into users (email, password) values (?, ?)";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, id);
        int rowAffected = preparedStatement.executeUpdate();

        System.out.println("("+rowAffected+") rows affected");
        conn.close();
    }
    public void depositFunds() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter Account ID ==> ");
        int id = sc.nextInt();
        System.out.print("  Enter Deposit Amount ==> ");
        double amt = sc.nextDouble();
        String query = "UPDATE accounts SET balance = balance + ? WHERE accountId = ?";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, id);
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") rows affected");
        conn.close();
    }
    public void transferFunds() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter Account ID ==> ");
        int id = sc.nextInt();
        System.out.print("  Enter Deposit Amount ==> ");
        double amt = sc.nextDouble();
        String query = "UPDATE accounts SET balance = balance + ? WHERE accountId = ?";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, id);
        int rowAffected = preparedStatement.executeUpdate();

        System.out.println("("+rowAffected+") rows affected");
        conn.close();
    }
    public void withdrawFunds() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "abc");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter Account ID ==> ");
        int id = sc.nextInt();
        System.out.print("  Enter Amount to Withdraw ==> ");
        double amt = sc.nextDouble();
        String query = "UPDATE accounts SET balance = balance - ? WHERE accountId = ?";
        PreparedStatement preparedStatement =  conn.prepareStatement(query);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, id);
        int rowAffected = preparedStatement.executeUpdate();

        System.out.println("("+rowAffected+") rows affected");
        conn.close();
    }
    public void getPendingTransfers() {

    }
    public void logout() {

    }

}