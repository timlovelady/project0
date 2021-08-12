import java.util.Scanner;

public class Menus {
    private Integer menuSelection;
    private String page = "home";
    int x = 0;
    Scanner sc = new Scanner(System.in);

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }


    public int printHomeMenu() {
        int x = 0;
        while (x < 1 || x > 4) {
        System.out.println(ColorTheme.YELLOW_BRIGHT +  "\nWelcome, Please choose from the following options " + ColorTheme.RESET + "\n" +
                "1) Log In\n" +
                "2) Register\n" +
                "3) Employee Login\n" +
                "4) Exit\n");

        System.out.print("Enter Choice Here ==> ");
        x = sc.nextInt();
        }
        return x;
    }
    public int printUserMenu() {
        while (x < 1 || x > 7) {
            System.out.println(ColorTheme.YELLOW_BRIGHT +  "\nWelcome, Please choose from the following options " + ColorTheme.RESET + "\n" +
                    "1) Create Account\n" +
                    "2) Withdraw\n" +
                    "3) Deposit\n" +
                    "4) View Balances\n" +
                    "5) Transfer Money\n" +
                    "6) Pending Transfers\n" +
                    "7) Logout");

            System.out.print("Enter Choice Here ==> ");
            x = sc.nextInt();
        }

        return x;
    }
    public void printCreateAccountMenu() {
        System.out.println("Please enter the amount to start your account with: (Enter dollars and cents ex 325.87)");
        double deposit = sc.nextDouble();
        System.out.println("Confirm deposit amount of " + deposit);
    }
    public double withdrawMenu() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        return amt;
    }
    public void depositMenu() {

    }
    public void printEmployeeMenu() {
        int x = 0;
        while (x < 1 || x > 4) {
            System.out.println(ColorTheme.YELLOW_BRIGHT +  "\nWelcome, Please choose from the following options " + ColorTheme.RESET + "\n" +
                    "1) View Accounts\n" +
                    "2) View Transactions\n" +
                    "3) Pending Accounts\n" +
                    "4) Exit\n");

            System.out.print("Enter Choice Here ==> ");
            x = sc.nextInt();
            setMenuSelection(x);
        }

    }
    public void setMenuSelection(int selection) {
        this.menuSelection = selection;
    }
    public int getMenuSelection() {
        return this.menuSelection;
    }
}
