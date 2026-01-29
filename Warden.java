public class Warden extends User {

    public Warden(String name) {
        this.name = name;
        this.role = "Warden";
    }

    @Override
    public void dashboard() {
        System.out.println("Warden Dashboard Accessed");
    }
}
