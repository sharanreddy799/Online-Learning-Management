package com.example.lms.service;
import com.example.lms.entity.User;
import com.example.lms.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        logger.debug("Registering user: {}", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false); // New users need admin approval
        User savedUser = userRepository.save(user);
        logger.debug("User registered: {}", savedUser.getUsername());
        return savedUser;
    }

    public User enableUser(Long userId) {
        logger.debug("Enabling user with ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setEnabled(true);
        User enabledUser = userRepository.save(user);
        logger.debug("User enabled: {}", enabledUser.getUsername());
        return enabledUser;
    }

    public User findByUsername(String username) {
        logger.debug("Finding user by username: {}", username);
        return userRepository.findByUsername(username);
    }
}