import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    UserDAO dao = UserDAOFactory.getUserDao();
    EmployeeDAO edao = EmployeeDAOFactory.getEmployeeDaoDao();
        Menus menus = new Menus();
        Scanner sc = new Scanner(System.in);
        boolean more = true;
        User user = new User();
        Employee employee = new Employee();
        while(more == true) {
            menus.printHomeMenu();
            System.out.print(ColorTheme.YELLOW_BRIGHT + "Enter selection here  ==>" + ColorTheme.RESET);
            int i = sc.nextInt();
            switch(i) {
                case 1:
                    System.out.println(ColorTheme.YELLOW_BRIGHT +  "\n*** Login ***\n" + ColorTheme.RESET);
                    System.out.print("Enter Email ==> ");
                    String email = sc.next();
                    System.out.print("Enter Password ==> ");
                    String password = sc.next();
                    user.setEmail(email);
                    user.setPassword(password);
                    dao.userLogin(user);
                    if(user.getUserId() < 1) {
                        System.out.println(ColorTheme.RED_BRIGHT + "Incorrect log in information" + ColorTheme.RESET);
                        break;
                    }
                    more = false;
                    break;
                case 2:
                    System.out.println(ColorTheme.YELLOW_BRIGHT +  "\n*** Register ***\n" + ColorTheme.RESET);
                    System.out.print("Enter Email ==> ");
                    email = sc.next();
                    System.out.print("Enter Password ==> ");
                    password = sc.next();
                    user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    int success = dao.registerUser(user);
                    if(success > 0) {
                        System.out.println("Registration successful");
                    }
                    break;
                case 3:
                    System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Employee Login ***\n" + ColorTheme.RESET);
                    System.out.print("Enter Email ==> ");
                    email = sc.next();
                    System.out.print("Enter Password ==> ");
                    password = sc.next();
                    employee.setEmail(email);
                    employee.setEmployeePassword(password);
                    edao.employeeLogin(employee);
                    more = false;
                    break;
                case 4:
                    more = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        }
        if(user.geLoggedIn()) {
            System.out.println("You are Logged in");
            more = true;
            while (more == true) {
                menus.printUserMenu();
                System.out.print(ColorTheme.YELLOW_BRIGHT + "Enter selection here  ==>" + ColorTheme.RESET);
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Create Account ***\n" + ColorTheme.RESET);
                        System.out.print("Enter amount of deposit ==> $");
                        double depositAmount = sc.nextDouble();
                        dao.createAccount(user, depositAmount);
                        break;
                    case 2:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Withdraw ***");
                        System.out.print("Enter amount of withdraw ==> $");
                        double withdrawAmount = sc.nextDouble();
                        System.out.print("Enter account number ==>");
                        int accountNumber = sc.nextInt();
                        dao.withdraw(withdrawAmount, accountNumber);
                        break;
                    case 3:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Deposit ***\n" + ColorTheme.RESET);
                        System.out.print("Enter amount of deposit ==> ");
                        double d = sc.nextDouble();
                        System.out.print("Enter account number ==> ");
                        accountNumber = sc.nextInt();
                        dao.deposit(d, accountNumber);
                        break;
                    case 4:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** View Balances ***\n" + ColorTheme.RESET);
                        dao.getAccounts(user);
                        break;
                    case 5:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** View Account ***\n" + ColorTheme.RESET);
                        System.out.print("Enter Account Number ==> ");
                        accountNumber = sc.nextInt();
                        dao.viewAccount(accountNumber);
                        break;
                    case 6:
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Transfer Money ***\n" + ColorTheme.RESET);
                        System.out.print("Enter amount of transfer ==> $");
                        double transferAmount = sc.nextDouble();
                        System.out.print("From Account ==>" );
                        int sendFrom = sc.nextInt();
                        System.out.print("To Account ==> ");
                        int sendTo = sc.nextInt();
                        System.out.println(ColorTheme.BLUE_BRIGHT + "Confirm Transfer amount of transfer $" + transferAmount + " from account " + sendFrom + " to account " + sendTo + ColorTheme.RESET);
                        System.out.println(ColorTheme.YELLOW_BRIGHT + "Press 1 to confirm or any other number to cancel" + ColorTheme.RESET);
                        int confirm = sc.nextInt();
                        if (confirm == 1) {
                            dao.transferMoney(user, transferAmount, sendTo, sendFrom);
                            System.out.println(ColorTheme.GREEN_BRIGHT + "Transfer Complete" + ColorTheme.RESET);
                        } else {
                            System.out.println(ColorTheme.RED_BRIGHT + "Transfer canceled" + ColorTheme.RESET);
                        }
                        break;
                    case 7:
                        more = false;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
            }
        }
            if(employee.isLoggedIn() == true) {
                more = true;
                while(more == true) {
                    menus.printEmployeeMenu();
                    System.out.print(ColorTheme.YELLOW_BRIGHT + "Enter selection here  ==>" + ColorTheme.RESET);
                    int a = sc.nextInt();
                    switch (a) {
                        case 1:
                            System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** View Accounts ***\n" + ColorTheme.RESET);
                            edao.viewAccounts();
                            break;
                        case 2:
                            System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Approve Account ***\n" + ColorTheme.RESET);
                            System.out.print("Enter transaction id ==>");
                            int transId = sc.nextInt();
                            edao.approveAccount(transId);
                            break;
                        case 3:
                            System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Deny Account ***\n" + ColorTheme.RESET);
                            System.out.print("Enter transaction id ==> ");
                            transId = sc.nextInt();
                            edao.denyAccount(transId);
                            break;
                        case 4:
                            System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** Pending Accounts ***\n" + ColorTheme.RESET);
                            edao.getPendingAccounts();
                            break;
                        case 5:
                            more = false;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + a);
                    }
                }

        }
        System.out.println("Program ended");
    }
}
