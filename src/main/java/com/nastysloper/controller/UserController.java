package com.nastysloper.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nastysloper.service.UserServiceImpl;
import com.nastysloper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   UserServiceImpl userService;

   @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
       List<User> users = userService.findAllUsers();
       if (users.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @RequestMapping(value="/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@ModelAttribute("User") User newUser) {
       User user = userService.createNewUser(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getImage());
       return new ResponseEntity<>(user, HttpStatus.OK);

   }
}
