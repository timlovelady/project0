public class UserDAOFactory {

    private static UserDAO dao;

    private UserDAOFactory(){}

    public static UserDAO getUserDao(){
        if(dao==null)
            dao = new UserDAOImplementation();
        return dao;
    }
}