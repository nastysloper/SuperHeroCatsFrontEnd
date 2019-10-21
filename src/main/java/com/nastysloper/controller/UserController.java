package com.nastysloper.controller;

import com.nastysloper.service.UserServiceImpl;
import com.nastysloper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   UserServiceImpl userService;

   @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
       List<User> users = userService.findAllUsers();
       if (users.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(users, HttpStatus.OK);
   }
}
