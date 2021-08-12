
import java.sql.SQLException;
import java.util.List;
public interface UserDAO {
    int registerUser(User user) throws SQLException;
    void userLogin(User user) throws SQLException;
    void deposit(double amt, int accountId) throws SQLException;
    void withdraw(double amt, int accountId) throws SQLException;
    void transferMoney(User user, double amt, int to, int from) throws  SQLException;
    void createAccount(User user, double amt) throws SQLException;
    void viewAccount(int accountId) throws SQLException;
    void getAccounts(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<User> getUsers();
    User userById(int id);
}
