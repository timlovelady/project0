public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private boolean loggedIn;
    public User(){}
    public User(int userId, String username, String email, String password, boolean loggedIn) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
    }
    public boolean geLoggedIn() {
        return this.loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    public void setPassword(String password) {
        this.password = password;
    }
}