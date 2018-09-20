package model;

public class User {
    private String password;
    private String username;

    public User() {
        username = "default";
        password = "password"; //just set a default password.
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public String getPassword() {
        return password;
    }

}
