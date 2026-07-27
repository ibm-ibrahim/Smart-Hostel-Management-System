package user.model;

public class Admin extends Role {

    public Admin(String name) {
        this.name = name;
        this.type = "Admin";
    }

    @Override
    public void dashboard() {
        System.out.println("Admin Dashboard Accessed");
    }
}
