package com.exam.examauthsystem.controllers;

import com.exam.examauthsystem.models.User;
import com.exam.examauthsystem.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            return "Login Successful! Role: " + dbUser.get().getClass().getSimpleName();
        }
        return "Invalid username or password";
    }
}