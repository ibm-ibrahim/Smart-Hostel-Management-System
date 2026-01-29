// Factory Pattern: Creates User objects without exposing logic

public class UserFactory {

    public static User createUser(String type, String name) {

        if (type.equalsIgnoreCase("ADMIN")) {
            return new Admin(name);
        }
        else if (type.equalsIgnoreCase("STUDENT")) {
            return new Student(name);
        }
        else if (type.equalsIgnoreCase("WARDEN")) {
            return new Warden(name);
        }
        else {
            return null;
        }
    }
}