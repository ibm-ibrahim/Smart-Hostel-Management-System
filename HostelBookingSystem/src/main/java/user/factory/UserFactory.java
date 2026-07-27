package user.factory;

// Factory Pattern: Creates Role objects without exposing creation logic

import user.model.Admin;
import user.model.Role;
import user.model.Student;
import user.model.Warden;

public class UserFactory {

    public static Role createUser(String type, String name) {

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
