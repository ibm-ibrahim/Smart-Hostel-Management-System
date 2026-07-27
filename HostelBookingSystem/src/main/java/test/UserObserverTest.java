package test;

import user.services.UserService;
import observer.NotificationObserver;
import observer.LogObserver;

public class UserObserverTest {

    public static void main(String[] args) {

        UserService userService = new UserService();

        // Attach observers
        userService.addObserver(new NotificationObserver());
        userService.addObserver(new LogObserver());

        // Register user (this should trigger both observers)
        userService.registerUser(
            "03123456789",
            "observer@test.com",
            "Observer Student",
            "pass123"
        );
    }
}
