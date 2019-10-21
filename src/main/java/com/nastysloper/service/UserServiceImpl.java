package com.nastysloper.service;

import com.nastysloper.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    User user = new User(0, "Adam", "proto@man.com");
    private List<User> users = populateMockUsers();

    @Override
    public User findById(long id) {
        return user;
    }

    @Override
    public User findByName(String name) {
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    public List<User> populateMockUsers() {
        User u1 = new User(1, "Rich", "rich@accenture.com");
        User u2 = new User(2, "Bryan", "bryan@arch.com");
        User u3 = new User(3, "Leo", "leo@bark.com");
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }
}
