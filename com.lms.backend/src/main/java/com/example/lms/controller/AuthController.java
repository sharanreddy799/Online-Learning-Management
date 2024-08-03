package com.example.lms.controller;
import com.example.lms.entity.User;
import com.example.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        logger.debug("Register request received for user: {}", user.getUsername());
        if (userService.findByUsername(user.getUsername()) != null) {
            logger.warn("Username is already taken: {}", user.getUsername());
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        userService.registerUser(user);
        logger.debug("User registered successfully: {}", user.getUsername());
        return ResponseEntity.ok("User registered successfully. Awaiting admin approval.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        logger.debug("Login request received for user: {}", user.getUsername());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.debug("User logged in successfully: {}", user.getUsername());
            User authenticatedUser = userService.findByUsername(user.getUsername());

            Map<String, Object> response = new HashMap<>();
            response.put("message", "User logged in successfully");
            response.put("role", authenticatedUser.getRole());
            response.put("username", authenticatedUser.getUsername());
            logger.debug("Response Sent:", response);
            return ResponseEntity.ok("User logged in successfully");
        } catch (Exception e) {
            logger.error("Login failed for user: {}", user.getUsername(), e);
            return ResponseEntity.status(401).body("Login failed");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/enable/{userId}")
    public ResponseEntity<?> enableUser(@PathVariable Long userId) {
        logger.debug("Enable user request received for user ID: {}", userId);
        userService.enableUser(userId);
        logger.debug("User enabled successfully: {}", userId);
        return ResponseEntity.ok("User enabled successfully");
    }
}
