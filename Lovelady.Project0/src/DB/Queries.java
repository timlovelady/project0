package DB;

public class Queries {

    // Inserts
    private String createEmployee = "insert into employees (username, password) VALUES (?, ?)";
    private final String createUser = "insert into users (username, password) VALUES (?, ?)";
    private final String createAccount = "insert into accounts (userId, balance) VALUES (?, ?)";

    // Selects
    private final String getAccounts = "select * from accounts where userId = ?";


    // Updates
    private final String approveAccount = "update accounts set approved = 1 where accountId = ?";
    private final String denyAccount = "update accounts set approved = 0 where accountId = ?";
    private final String approveTransfer  = "update transfers set approved = 1 where transferId = ?";
    private final String declineTransfer  = "update transfers set approved = 1 where transferId = ?";

    // Deletes
    private final String deleteAccount = "drop from accounts where accountId = ?";
    private final String deleteUser = "drop from users where userId = ?";
    private final String deleteEmployee = "drop from employees where employeeId = ?";
}

