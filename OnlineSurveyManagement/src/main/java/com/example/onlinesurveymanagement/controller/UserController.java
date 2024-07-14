package com.example.onlinesurveymanagement.controller;

import com.example.onlinesurveymanagement.model.User;
import com.example.onlinesurveymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // Retrieve user by ID from repository
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Update user details in repository
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            // Update other fields as needed
            userRepository.save(user);
        }
        return user;
    }

    // Implement other CRUD operations for users here
}
