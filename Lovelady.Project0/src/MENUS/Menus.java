package MENUS;

import java.util.Scanner;

public class Menus {
    Scanner sc = new Scanner(System.in);
    private int currentOption = 0;

    public void setCurrentOption(int currentOption) {
        this.currentOption = currentOption;
    }
    public int getCurrentOption() {
        System.out.println("Current Option: " + currentOption);
        return this.currentOption;
    }

    public void printUserMenu() {
        System.out.println(
                "********************************************* \n" +
                "***************  User menu   **************** \n" +
                "********************************************* \n");
        System.out.println("" +
                " (1)  Register\n (2)  Log In\n (3)  Employee Login\n");
        System.out.print("Please enter your selection:  ");
        setCurrentOption(sc.nextInt());
    }

   public void printCustomerMenu() {
        System.out.println(
                    "*********************************************\n" +
                        "*************  Customer menu   **************\n" +
                        "*********************************************\n");
        System.out.println("" +
                "(1)  Log Out\n" +
                "(2)  Create Account\n" +
                "(3)  Transfer\n" +
                "(4)  Close Account\n" +
                "(5)  Deposit\n" +
                "(6)  Pending Transfers");

       System.out.print("Please enter your selection:  ");
       setCurrentOption(sc.nextInt());
    }

    public void printCreateAccountMenu() {
        System.out.println(
                "*********************************************\n" +
                        "*************  Create Account   **************\n" +
                        "*********************************************\n");
        System.out.println("  Choose Account Type" +
                "(1)  Checking\n" +
                "(2)  Savings\n");
        System.out.print("Please enter your selection:  ");
        setCurrentOption(sc.nextInt());
    }
}
