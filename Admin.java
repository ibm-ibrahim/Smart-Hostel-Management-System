public class Admin extends User {

    public Admin(String name) {
        this.name = name;
        this.role = "Admin";
    }

    @Override
    public void dashboard() {
        System.out.println("Admin Dashboard Accessed");
    }
}
