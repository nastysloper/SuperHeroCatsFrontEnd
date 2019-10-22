package com.nastysloper.service;

import com.nastysloper.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);

    Optional<User> findByName(String name);

    List<User> findAllUsers();

    User createNewUser(long id, String name, String email, String image);
}
