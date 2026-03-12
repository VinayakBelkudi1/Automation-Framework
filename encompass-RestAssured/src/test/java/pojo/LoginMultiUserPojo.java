package pojo;

public class LoginMultiUserPojo {
    
    private String username;
    private String password;

    public LoginMultiUserPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {     // ✅ FIXED
        return username;
    }

    public void setUsername(String username) {   // ✅ FIXED
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
