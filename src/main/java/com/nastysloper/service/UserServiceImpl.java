package com.nastysloper.service;

import com.nastysloper.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = populateMockUsers();

    @Override
    public Optional<User> findById(long id) {
        for (User u : users) {
            if (u.getId() == id) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String name) {
        for (User u : users) {
            if (u.getName() == name) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<User> findAllUsers() {
        return users;
    }

    @Override
    public User createNewUser(long id, String name, String email, String image) {
        User user = new User(id, name, email, image);
        users.add(user);
        return user;
}

    public ArrayList<User> populateMockUsers() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new User(1, "Fluffy", "fluff@fluff.com", "https://placekitten.com/96/139");
        User u2 = new User(2, "Tiny", "tiny@tiny.com", "https://placekitten.com/76/139");
        User u3 = new User(3, "Werewolf", "were@wolf.com", "https://placekitten.com/75/139");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }
}
