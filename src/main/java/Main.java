import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        User user = new User();
        UserDAO dao = new UserDAOImplementation();
        Menus menus = new Menus();
        Scanner sc = new Scanner(System.in);

        int a = menus.printHomeMenu();
        switch(a) {
            case 1:
                System.out.print("Enter username ==>");
                user.setUsername(sc.next());
                System.out.print("Enter password =>");
                user.setPassword(sc.next());
                System.out.println("Username: " + user.getUsername() + "\n" + "Password: " + user.getPassword());
                dao.userLogin(user);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }


    }
}
