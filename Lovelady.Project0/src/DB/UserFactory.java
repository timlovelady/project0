package DB;

public class UserFactory {
    private static UserDao dao;

    private UserFactory(){}

    public static UserDao getUserDao(){
        if(dao==null)
            dao = new UserDao();
        return dao;
    }
}
