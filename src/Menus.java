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


    public void printHomeMenu() {
            System.out.println(ColorTheme.YELLOW_BRIGHT +  "\nWelcome, Please choose from the following options " + ColorTheme.RESET + "\n" +
                    ColorTheme.BLUE_BRIGHT + "1) Log In\n" +
                    "2) Register\n" +
                    "3) Employee Login\n" +
                    "4) Exit\n" + ColorTheme.RESET);
    }
    public void printUserMenu() {
            System.out.println(ColorTheme.YELLOW_BRIGHT +  "\n*** USER MENU ***\n Please select an option" + ColorTheme.RESET + "\n" +
                    ColorTheme.BLUE_BRIGHT + "1) Create Account\n" +
                    ColorTheme.BLUE_BRIGHT + "2) Withdraw\n" +
                    ColorTheme.BLUE_BRIGHT + "3) Deposit\n" +
                    ColorTheme.BLUE_BRIGHT + "4) View Balances\n" +
                    ColorTheme.BLUE_BRIGHT + "5) View Account\n" +
                    ColorTheme.BLUE_BRIGHT + "6) Transfer Money\n" +
                    ColorTheme.BLUE_BRIGHT + "7) Logout");
    }
    public void printEmployeeMenu() {
            System.out.println(ColorTheme.YELLOW_BRIGHT + "\n*** EMPLOYEE MENU ***\n" + ColorTheme.RESET + "\n" +
                    ColorTheme.BLUE_BRIGHT + "1) View Accounts\n" +
                    ColorTheme.BLUE_BRIGHT +" 2) Approve Account\n" +
                    ColorTheme.BLUE_BRIGHT +" 3) Deny Account\n" +
                    ColorTheme.BLUE_BRIGHT + "4) Pending Accounts\n" +
                    ColorTheme.BLUE_BRIGHT + "5) Exit\n");
        }
}
