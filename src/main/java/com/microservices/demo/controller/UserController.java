package com.microservices.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.demo.entity.User;
import com.microservices.demo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        logger.debug("Saving user");
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        logger.debug("Get all users");
        return userService.fetchAllUsers();
    }



    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        logger.debug("Updating user");
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        logger.debug("Deleting user");
        return userService.deleteUserById(id);
    }
}