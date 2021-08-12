import java.sql.SQLException;
import java.util.List;
public interface EmployeeDAO {
    int registerEmployee(Employee employee) throws SQLException;
    void getPendingAccounts() throws  SQLException;
    void employeeLogin(Employee employee) throws SQLException;
    void approveAccount(int transactionId) throws SQLException;
    void denyAccount(int transactionId) throws SQLException;
    void viewAccounts() throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployee();
    Employee employeeById(int id);
}