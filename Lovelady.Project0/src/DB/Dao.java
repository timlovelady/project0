package DB;

import java.util.List;
import java.sql.SQLException;
public interface Dao <T> {
    List<T> getAll() throws SQLException;

    void save(T t);

    void login(T t, String[] params) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t) throws SQLException;
}
