package user.services;

import user.dao.UserDAO;
import user.model.User;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class UserService implements Subject {

    private UserDAO dao = new UserDAO();
    private List<Observer> observers = new ArrayList<>();

    // Observer methods
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    // Register user
    public void registerUser(String phone, String email, String name, String password){
        User user = new User(phone, email, name, password);
        dao.saveUser(user);

        // Notify observers
        notifyObservers("New student registered: " + email);
    }

    // Login user
    public boolean loginUser(String email, String password){
        return dao.verifyUser(email, password);
    }
}
