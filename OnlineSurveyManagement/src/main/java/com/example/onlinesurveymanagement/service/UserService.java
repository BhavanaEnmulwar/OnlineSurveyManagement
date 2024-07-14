package com.example.onlinesurveymanagement.service;

import com.example.onlinesurveymanagement.model.User;

import com.example.onlinesurveymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void updateUserPassword(User user, String newPassword) {
        // Encrypt the password before setting it
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword); // Use setPassword method of User class
        // Save the user object to the database or perform other necessary actions
    }
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
