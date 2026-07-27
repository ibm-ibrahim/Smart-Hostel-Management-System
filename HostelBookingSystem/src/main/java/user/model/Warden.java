package user.model;

public class Warden extends Role {

    public Warden(String name) {
        this.name = name;
        this.type = "Warden";
    }

    @Override
    public void dashboard() {
        System.out.println("Warden Dashboard Accessed");
    }
}
