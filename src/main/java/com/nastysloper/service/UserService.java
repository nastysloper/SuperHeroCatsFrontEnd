package com.nastysloper.service;

import com.nastysloper.model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    User findByName(String name);

    List<User> findAllUsers();
}
