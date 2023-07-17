package com.microservices.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.demo.repository.UserRepository;
import com.microservices.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        logger.debug("Saving user");
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUserById(Long id, User User) {
        logger.debug("Updating User");
        Optional<User> user1 = userRepository.findById(id);

        if (user1.isPresent()) {
            User originaluser = user1.get();
            return userRepository.save(originaluser);
        }
        return null;
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "user deleted successfully";
        }
        return "No such user in the database";
    }

}
