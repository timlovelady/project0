
import java.sql.SQLException;
import java.util.List;
public interface UserDAO {
    int registerUser(User user) throws SQLException;
    int userLogin(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<User> getUser();
    User userById(int id);


}
