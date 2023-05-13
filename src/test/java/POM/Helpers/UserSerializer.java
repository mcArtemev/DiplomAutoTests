package POM.Helpers;

public class UserSerializer {
    private String name;
    private String email;
    private String password;

    public UserSerializer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserSerializer(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
