import user.services.UserService;

public class TestUser {
    public static void main(String[] args) {
        UserService service = new UserService();

        // Hardcoded test user
        service.registerUser("03001234567", "ali@gmail.com", "Ali", "pass123");

        System.out.println("User registered!");
    }
}
