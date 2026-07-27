package user.model;

public class User {
    private String phone;
    private String email;
    private String name;
    private String password;

    public User(String phone, String email, String name, String password){
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
