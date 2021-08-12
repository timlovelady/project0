import java.sql.SQLException;
import java.util.List;

public interface Dao {
    int register(User user) throws SQLException;
    int login(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(int id) throws SQLException;
    List<User> getObj();
    User getById(int id);
}
