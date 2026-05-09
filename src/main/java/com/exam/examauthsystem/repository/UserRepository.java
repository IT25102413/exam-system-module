package com.exam.examauthsystem.repositories;

import com.exam.examauthsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Read: Find a user by username for the login system [cite: 8]
    Optional<User> findByUsername(String username);
}