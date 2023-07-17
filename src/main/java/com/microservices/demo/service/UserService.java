package com.microservices.demo.service;



import java.util.List;

import  com.microservices.demo.entity.User;

public interface UserService {

    User saveUser(User user);

    List<User> fetchAllUsers();

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    String deleteUserById(Long id);
}
