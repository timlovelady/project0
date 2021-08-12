public class Employee {

    private int employeeId;
    private String username;
    private String email;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeename() {
        return username;
    }

    public void setEmployeeName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmployeePassword(String password) {
        this.password = password;
    }

    private String password;
    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public Employee(){}
    public Employee(int employeeId, String username, String email, String password, boolean loggedIn) {
        this.employeeId = employeeId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
    }
}
