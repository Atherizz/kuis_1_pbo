public class User {
    private String username;
    private String email;
    private String password;
    private int saldo;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.saldo = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword)) {
            setPassword(newPassword);
        } else {
            System.out.println("Old password is incorrect.");
        }
    }
    

}
